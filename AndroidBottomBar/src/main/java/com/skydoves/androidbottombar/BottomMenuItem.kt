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
import com.skydoves.androidbottombar.extensions.contextColor
import com.skydoves.androidbottombar.extensions.dp2Px
import com.skydoves.androidbottombar.extensions.resourceDrawable
import com.skydoves.androidbottombar.forms.BadgeForm
import com.skydoves.androidbottombar.forms.IconForm
import com.skydoves.androidbottombar.forms.TitleForm

/**
 * [BottomMenuItem] is a collection of [BottomMenuItemView] attributes.
 * Composed to [TitleForm], [IconForm], and [BadgeForm] with fully customizable.
 * Each form can be reused for setting up multiple menu items.
 */
open class BottomMenuItem(val context: Context) {

  @JvmField
  var titleForm = TitleForm()

  @JvmField
  var iconForm = IconForm()

  @JvmField
  var badgeForm = BadgeForm()

  /** sets a customized [TitleForm]. */
  fun setTitleForm(value: TitleForm) = apply { this.titleForm = value.copy() }

  /** sets a customized [IconForm]. */
  fun setIconForm(value: IconForm) = apply { this.iconForm = value.copy() }

  /** sets a customized [BadgeForm]. */
  fun setBadgeForm(value: BadgeForm) = apply { this.badgeForm = value.copy() }

  /** sets the content of the title. */
  fun setTitle(value: CharSequence) = apply { this.titleForm.title = value }

  /** sets the content of the title using string resource. */
  fun setTitle(@StringRes value: Int) = apply { this.titleForm.title = context.getString(value) }

  /** sets the color of the title. */
  fun setTitleColor(@ColorInt value: Int) = apply { this.titleForm.titleColor = value }

  /** sets the color of the title using resource. */
  fun setTitleColorRes(@ColorRes value: Int) = apply { this.titleForm.titleColor = context.contextColor(value) }

  /** sets the color of the title. */
  fun setTitleActiveColor(@ColorInt value: Int) = apply { this.titleForm.titleActiveColor = value }

  /** sets the color of the title using resource. */
  fun setTitleActiveColorRes(@ColorRes value: Int) = apply { this.titleForm.titleActiveColor = context.contextColor(value) }

  /** sets the size of the title. */
  fun setTitleSize(@Sp value: Float) = apply { this.titleForm.titleSize = value }

  /** sets the [Typeface] of the title. */
  fun setTitleTypeface(value: Int) = apply { this.titleForm.titleStyle = value }

  /** sets the [Typeface] of the title. */
  fun setTitleTypeface(value: Typeface?) = apply { this.titleForm.titleTypeface = value }

  /** sets the padding of the title. */
  fun setTitlePadding(@Dp value: Int) = apply { this.titleForm.titlePadding = context.dp2Px(value) }

  /** sets gravity of the title. */
  fun setTitleGravity(value: Int) = apply { this.titleForm.titleGravity = value }

  /** sets the [Drawable] of the icon. */
  fun setIcon(value: Drawable?) = apply { this.iconForm.icon = value }

  /** sets the [Drawable] of the icon using resource. */
  fun setIcon(@DrawableRes value: Int) = apply {
    this.iconForm.icon = context.resourceDrawable(value)
  }

  /** sets the size of the icon. */
  fun setIconSize(@Dp value: Int) = apply { this.iconForm.iconSize = context.dp2Px(value) }

  /** sets the color of the icon. */
  fun setIconColor(@ColorInt value: Int) = apply { this.iconForm.iconColor = value }

  /** sets the color of the icon using resource */
  fun setIconColorRes(@ColorRes value: Int) = apply {
    this.iconForm.iconColor = context.contextColor(value)
  }

  /** sets the color of the icon. */
  fun setIconActiveColor(@ColorInt value: Int) = apply { this.iconForm.iconActiveColor = value }

  /** sets the color of the icon using resource */
  fun setIconActiveColorRes(@ColorRes value: Int) = apply {
    this.iconForm.iconActiveColor = context.contextColor(value)
  }

  /** sets a background drawable of the badge */
  fun setBadge(value: Drawable?) = apply { this.badgeForm.badge = value }

  /** sets the content of the badge. */
  fun setBadgeText(value: CharSequence) = apply { this.badgeForm.badgeText = value }

  /** sets the content of the badge using string resource. */
  fun setBadgeText(@StringRes value: Int) = apply { this.badgeForm.badgeText = context.getString(value) }

  /** sets the text color of the badge. */
  fun setBadgeTextColor(@ColorInt value: Int) = apply { this.badgeForm.badgeTextColor = value }

  /** sets the text color of the badge using resource. */
  fun setBadgeTextColorRes(@ColorRes value: Int) = apply {
    this.badgeForm.badgeTextColor = context.contextColor(value)
  }

  /** sets the size of the badge. */
  fun setBadgeTextSize(@Sp value: Float) = apply { this.badgeForm.badgeTextSize = value }

  /** sets the color of the badge. */
  fun setBadgeColor(@ColorInt value: Int) = apply { this.badgeForm.badgeColor = value }

  /** sets the color of the badge using resource. */
  fun setBadgeColorRes(@ColorRes value: Int) = apply { this.badgeForm.badgeColor = context.contextColor(value) }

  /** sets the [Typeface] of the badge. */
  fun setBadgeStyle(value: Int) = apply { this.badgeForm.badgeStyle = value }

  /** sets the [Typeface] of the badge. */
  fun setBadgeTypeface(value: Typeface?) = apply { this.badgeForm.badgeTypeface = value }

  /** sets the margin of the badge. */
  fun setBadgeMargin(@Dp value: Int) = apply { this.badgeForm.badgeMargin = context.dp2Px(value) }

  /** sets the padding of the badge. */
  fun setBadgePadding(@Dp value: Int) = apply {
    this.badgeForm.badgePaddingLeft = context.dp2Px(value)
    this.badgeForm.badgePaddingTop = context.dp2Px(value)
    this.badgeForm.badgePaddingRight = context.dp2Px(value)
    this.badgeForm.badgePaddingBottom = context.dp2Px(value)
  }

  /** sets the left padding of the badge. */
  fun setBadgePaddingLeft(@Dp value: Int) = apply { this.badgeForm.badgePaddingLeft = context.dp2Px(value) }

  /** sets the top padding of the badge. */
  fun setBadgePaddingTop(@Dp value: Int) = apply { this.badgeForm.badgePaddingTop = context.dp2Px(value) }

  /** sets the right padding of the badge. */
  fun setBadgePaddingRight(@Dp value: Int) = apply { this.badgeForm.badgePaddingRight = context.dp2Px(value) }

  /** sets the bottom padding of the badge. */
  fun setBadgePaddingBottom(@Dp value: Int) = apply { this.badgeForm.badgePaddingBottom = context.dp2Px(value) }

  /** sets the radius of the badge. */
  fun setBadgeRadius(@Dp value: Int) = apply { this.badgeForm.badgeRadius = context.dp2Px(value) }

  /** sets gravity of the badge. */
  fun setBadgeGravity(value: Int) = apply { this.badgeForm.badgeGravity = value }

  /** sets an animation of the badge. */
  fun setBadgeAnimation(value: BadgeAnimation) = apply { this.badgeForm.badgeAnimation = value }

  /** sets an badge animation interpolator of the badge. */
  fun setBadgeAnimationInterpolator(value: BadgeAnimationInterpolator) = apply {
    this.badgeForm.badgeAnimationInterpolator = value
  }

  /** sets a duration of the badge. */
  fun setBadgeDuration(value: Long) = apply { this.badgeForm.badgeDuration = value }

  /** returns a [BottomMenuItem]. */
  fun build() = this
}
