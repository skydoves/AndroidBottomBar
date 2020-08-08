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

@file:Suppress("unused")

package com.skydoves.androidbottombar

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.skydoves.androidbottombar.animations.BadgeAnimation
import com.skydoves.androidbottombar.animations.BadgeAnimationInterpolator
import com.skydoves.androidbottombar.annotations.Dp
import com.skydoves.androidbottombar.annotations.Sp
import com.skydoves.androidbottombar.forms.BadgeForm
import com.skydoves.androidbottombar.forms.IconForm
import com.skydoves.androidbottombar.forms.TitleForm

/**
 * [BottomMenuItem] is a collection of [BottomMenuItemView] attributes.
 * Composed to [TitleForm], [IconForm], and [BadgeForm] with fully customizable.
 * Each builder of the form can be reused for setting up multiple menu items.
 */
open class BottomMenuItem(context: Context) {

  @JvmField
  var titleForm = TitleForm.Builder(context)

  @JvmField
  var iconForm = IconForm.Builder(context)

  @JvmField
  var badgeForm = BadgeForm.Builder(context)

  /** sets a customized [TitleForm.Builder]. */
  fun setTitleForm(value: TitleForm.Builder) = apply { this.titleForm = value.copy() }

  /** sets a customized [IconForm.Builder]. */
  fun setIconForm(value: IconForm.Builder) = apply { this.iconForm = value.copy() }

  /** sets a customized [BadgeForm.Builder]. */
  fun setBadgeForm(value: BadgeForm.Builder) = apply { this.badgeForm = value.copy() }

  /** sets the content of the title. */
  fun setTitle(value: CharSequence) = apply { this.titleForm.setTitle(value) }

  /** sets the content of the title using string resource. */
  fun setTitle(@StringRes value: Int) = apply { this.titleForm.setTitle(value) }

  /** sets the color of the title. */
  fun setTitleColor(@ColorInt value: Int) = apply { this.titleForm.setTitleColor(value) }

  /** sets the color of the title using resource. */
  fun setTitleColorRes(@ColorRes value: Int) = apply { this.titleForm.setTitleColorRes(value) }
  
  /** sets the color of the title. */
  fun setTitleActiveColor(@ColorInt value: Int) = apply { this.titleForm.setTitleActiveColor(value) }
  
  /** sets the color of the title using resource. */
  fun setTitleActiveColorRes(@ColorRes value: Int) = apply { this.titleForm.setTitleActiveColorRes(value) }

  /** sets the size of the title. */
  fun setTitleSize(@Sp value: Float) = apply { this.titleForm.setTitleSize(value) }

  /** sets the [Typeface] of the title. */
  fun setTitleTypeface(value: Int) = apply { this.titleForm.setTitleStyle(value) }

  /** sets the [Typeface] of the title. */
  fun setTitleTypeface(value: Typeface?) = apply { this.titleForm.setTitleTypeface(value) }

  /** sets the padding of the title. */
  fun setTitlePadding(@Dp value: Int) = apply { this.titleForm.setTitlePadding(value) }

  /** sets gravity of the title. */
  fun setTitleGravity(value: Int) = apply { this.titleForm.setTitleGravity(value) }

  /** sets the [Drawable] of the icon. */
  fun setIcon(value: Drawable?) = apply { this.iconForm.setIcon(value) }

  /** sets the [Drawable] of the icon using resource. */
  fun setIcon(@DrawableRes value: Int) = apply {
    this.iconForm.setIcon(value)
  }

  /** sets the size of the icon. */
  fun setIconSize(@Dp value: Int) = apply { this.iconForm.setIconSize(value) }

  /** sets the color of the icon. */
  fun setIconColor(@ColorInt value: Int) = apply { this.iconForm.setIconColor(value) }

  /** sets the color of the icon using resource */
  fun setIconColorRes(@ColorRes value: Int) = apply {
    this.iconForm.setIconColorRes(value)
  }
  
  /** sets the color of the icon. */
  fun setIconActiveColor(@ColorInt value: Int) = apply { this.iconForm.setIconActiveColor(value) }
  
  /** sets the color of the icon using resource */
  fun setIconActiveColorRes(@ColorRes value: Int) = apply {
    this.iconForm.setIconActiveColorRes(value)
  }

  /** sets a background drawable of the badge */
  fun setBadge(value: Drawable?) = apply { this.badgeForm.setBadge(value) }

  /** sets the content of the badge. */
  fun setBadgeText(value: CharSequence) = apply { this.badgeForm.setBadgeText(value) }

  /** sets the content of the badge using string resource. */
  fun setBadgeText(@StringRes value: Int) = apply { this.badgeForm.setBadgeText(value) }

  /** sets the text color of the badge. */
  fun setBadgeTextColor(@ColorInt value: Int) = apply { this.badgeForm.setBadgeTextColor(value) }

  /** sets the text color of the badge using resource. */
  fun setBadgeTextColorRes(@ColorRes value: Int) = apply {
    this.badgeForm.setBadgeTextColorRes(value)
  }

  /** sets the size of the badge. */
  fun setBadgeTextSize(@Sp value: Float) = apply { this.badgeForm.setBadgeTextSize(value) }

  /** sets the color of the badge. */
  fun setBadgeColor(@ColorInt value: Int) = apply { this.badgeForm.setBadgeColor(value) }

  /** sets the color of the badge using resource. */
  fun setBadgeColorRes(@ColorRes value: Int) = apply { this.badgeForm.setBadgeColorRes(value) }

  /** sets the [Typeface] of the badge. */
  fun setBadgeStyle(value: Int) = apply { this.badgeForm.setBadgeStyle(value) }

  /** sets the [Typeface] of the badge. */
  fun setBadgeTypeface(value: Typeface?) = apply { this.badgeForm.setBadgeTypeface(value) }

  /** sets the margin of the badge. */
  fun setBadgeMargin(@Dp value: Int) = apply { this.badgeForm.setBadgeMargin(value) }

  /** sets the padding of the badge. */
  fun setBadgePadding(@Dp value: Int) = apply { this.badgeForm.setBadgePadding(value) }

  /** sets the left padding of the badge. */
  fun setBadgePaddingLeft(@Dp value: Int) = apply { this.badgeForm.setBadgePaddingLeft(value) }

  /** sets the top padding of the badge. */
  fun setBadgePaddingTop(@Dp value: Int) = apply { this.badgeForm.setBadgePaddingTop(value) }

  /** sets the right padding of the badge. */
  fun setBadgePaddingRight(@Dp value: Int) = apply { this.badgeForm.setBadgePaddingRight(value) }

  /** sets the bottom padding of the badge. */
  fun setBadgePaddingBottom(@Dp value: Int) = apply { this.badgeForm.setBadgePaddingBottom(value) }

  /** sets the radius of the badge. */
  fun setBadgeRadius(@Dp value: Int) = apply { this.badgeForm.setBadgeRadius(value) }

  /** sets gravity of the badge. */
  fun setBadgeGravity(value: Int) = apply { this.badgeForm.setBadgeGravity(value) }

  /** sets an animation of the badge. */
  fun setBadgeAnimation(value: BadgeAnimation) = apply { this.badgeForm.setBadgeAnimation(value) }

  /** sets an badge animation interpolator of the badge. */
  fun setBadgeAnimationInterpolator(value: BadgeAnimationInterpolator) = apply {
    this.badgeForm.setBadgeAnimationInterpolator(value)
  }

  /** sets a duration of the badge. */
  fun setBadgeDuration(value: Long) = apply { this.badgeForm.setBadgeDuration(value) }

  /** returns a [BottomMenuItem]. */
  fun build() = this
}
