/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.androidbottombar

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.widget.ImageViewCompat
import com.skydoves.androidbottombar.animations.BadgeAnimation
import com.skydoves.androidbottombar.animations.getInterpolator
import com.skydoves.androidbottombar.databinding.LayoutBottomMenuItemBinding
import com.skydoves.androidbottombar.extensions.animateFade
import com.skydoves.androidbottombar.extensions.animateScale
import com.skydoves.androidbottombar.extensions.applyBadgeForm
import com.skydoves.androidbottombar.extensions.applyIconForm
import com.skydoves.androidbottombar.extensions.applyTitleForm
import com.skydoves.androidbottombar.extensions.translateY
import com.skydoves.androidbottombar.extensions.visible

/**
 * [BottomMenuItemView] is an bottom menu item view with badges and
 * selected/unselected animations. Composed to title, icon, and badge.
 */
class BottomMenuItemView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null
) : FrameLayout(context, attrs, 0) {

  private val binding: LayoutBottomMenuItemBinding =
    LayoutBottomMenuItemBinding.inflate(LayoutInflater.from(context), this, true)

  private var layoutHeight: Float = 0f
  private var selectedView: View = binding.title
  private var unSelectedView: View = binding.icon

  var onMenuItemClickListener:
    (config: BottomMenuItemViewConfig?, view: BottomMenuItemView) -> Unit? = { _, _ -> }

  init {
    binding.root.setOnClickListener { onMenuItemClickListener(config, this) }
  }

  var config: BottomMenuItemViewConfig? = null
    set(value) {
      if (value != null) {
        field = value
        updateBottomMenuItemViewConfig(value)
      }
    }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    layoutHeight = h.toFloat()
  }

  private fun updateBottomMenuItemViewConfig(config: BottomMenuItemViewConfig) {
    with(binding) {
      val menuItem = config.bottomMenuItem
      title.applyTitleForm(menuItem.titleForm.build())
      icon.applyIconForm(menuItem.iconForm.build())
      badge.applyBadgeForm(menuItem.badgeForm.build())
      when (config.bottomBarFlavor) {
        BottomBarFlavor.ICON -> {
          icon.visible(true)
          title.visible(false)
          selectedView = title
          unSelectedView = icon
        }
        BottomBarFlavor.TITLE -> {
          icon.visible(false)
          title.visible(true)
          selectedView = icon
          unSelectedView = title
        }
      }
    }
  }

  /** updates and animates for a selected bottom bar item. */
  fun selectedBottomBarItem() {
    val config: BottomMenuItemViewConfig = config ?: return
    post {
      translateViewUp(
        target = selectedView,
        config = config,
        from = layoutHeight)
      translateViewDown(
        target = unSelectedView,
        config = config,
        to = -layoutHeight)
    }
  }

  /** updates and animates for an unselected bottom bar item. */
  fun unselectedBottomBarItem() {
    val config: BottomMenuItemViewConfig = config ?: return
    post {
      translateViewDown(
        target = selectedView,
        config = config,
        to = layoutHeight)
      translateViewUp(
        target = unSelectedView,
        config = config,
        from = -layoutHeight)
    }
  }

  fun setIsActive(isActive: Boolean) {
    this.config?.let { config ->
      binding.title.setTextColor(
        if (isActive) config.bottomMenuItem.titleForm.titleActiveColor
        else config.bottomMenuItem.titleForm.titleColor)
      ImageViewCompat.setImageTintList(
        binding.icon,
        ColorStateList.valueOf(
          if (isActive) config.bottomMenuItem.iconForm.iconActiveColor
          else config.bottomMenuItem.iconForm.iconColor)
      )
    }
  }

  /** shows the badge with a changed text and appearing animation. */
  fun showBadge(badgeText: CharSequence?) {
    val config: BottomMenuItemViewConfig = config ?: return
    val badgeForm = config.bottomMenuItem.badgeForm
    with(binding.badge) {
      visible(true)
      badgeText?.let { binding.badge.text = it }
      measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
      x = when (config.bottomBarFlavor) {
        BottomBarFlavor.TITLE -> binding.title.x + binding.title.width / 2 - width / 2
        BottomBarFlavor.ICON -> binding.icon.x + binding.icon.width / 2 - width / 2
      }
      when (badgeForm.badgeAnimation) {
        BadgeAnimation.NONE -> Unit
        BadgeAnimation.SCALE -> {
          scaleX = 0f
          scaleY = 0f
          animateScale(
            toX = 1.0f,
            toY = 1.0f,
            duration = badgeForm.badgeDuration,
            interpolator = badgeForm.badgeAnimationInterpolator.getInterpolator())
        }
        BadgeAnimation.FADE -> {
          alpha = 0f
          animateFade(
            alpha = 1.0f,
            duration = badgeForm.badgeDuration,
            interpolator = badgeForm.badgeAnimationInterpolator.getInterpolator())
        }
      }
    }
  }

  /** dismisses the badge. */
  fun dismissBadge() = binding.badge.visible(false)

  private fun translateViewUp(
    target: View,
    config: BottomMenuItemViewConfig,
    from: Float
  ) {
    target.translateY(
      from = from,
      to = 0f,
      config = config,
      onStart = { it.visible(true) })
  }

  private fun translateViewDown(
    target: View,
    config: BottomMenuItemViewConfig,
    to: Float
  ) {
    target.translateY(
      from = 0f,
      to = to,
      config = config,
      onStart = { it.visible(false) })
  }
}
