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

package com.skydoves.androidbottombar.forms

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.Gravity
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Px
import androidx.annotation.StringRes
import com.skydoves.androidbottombar.animations.BadgeAnimation
import com.skydoves.androidbottombar.animations.BadgeAnimationInterpolator
import com.skydoves.androidbottombar.annotations.Dp
import com.skydoves.androidbottombar.annotations.Sp
import com.skydoves.androidbottombar.extensions.accentColor
import com.skydoves.androidbottombar.extensions.contextColor
import com.skydoves.androidbottombar.extensions.dp2Px

@DslMarker
internal annotation class BadgeFormDsl

/** creates an instance of [BadgeForm] from [BadgeForm.Builder] using kotlin dsl. */
@BadgeFormDsl
@JvmSynthetic
inline fun badgeForm(context: Context, block: BadgeForm.Builder.() -> Unit): BadgeForm =
  BadgeForm.Builder(context).apply(block).build()

/**
 * [BadgeForm] is an attribute class that has some attributes about text
 * for customizing menu item badge easily.
 */
data class BadgeForm(

  var badge: Drawable? = null,
  var badgeText: CharSequence = "",
  var badgeStyle: Int = Typeface.NORMAL,
  var badgeTypeface: Typeface? = null,
  var badgeGravity: Int = Gravity.CENTER,
  var badgeDuration: Long = 300L,
  var badgeAnimation: BadgeAnimation = BadgeAnimation.NONE,
  var badgeAnimationInterpolator: BadgeAnimationInterpolator = BadgeAnimationInterpolator.NORMAL,

  @ColorInt var badgeTextColor: Int = Color.WHITE,
  @Sp var badgeTextSize: Float = 9f,
  @ColorInt var badgeColor: Int = Color.BLACK,
  @Px var badgeMargin: Int = 8,
  @Px var badgePaddingLeft: Int = 6,
  @Px var badgePaddingTop: Int = 2,
  @Px var badgePaddingRight: Int = 6,
  @Px var badgePaddingBottom: Int = 2,
  @Px var badgeRadius: Int = 16

) {

  /** Builder class for [BadgeForm]. */
  @BadgeFormDsl
  data class Builder(private val context: Context) {

    @JvmField
    var badge: Drawable? = null

    @JvmField
    var badgeText: CharSequence = ""

    @ColorInt
    @JvmField
    var badgeTextColor: Int = Color.WHITE

    @Sp
    @JvmField
    var badgeTextSize: Float = 9f

    @ColorInt
    @JvmField
    var badgeColor: Int = context.accentColor()

    @JvmField
    var badgeStyle = Typeface.NORMAL

    @JvmField
    var badgeTypeface: Typeface? = null

    @Px
    private var _badgeMargin: Int = context.dp2Px(8)

    var badgeMargin: Int
      @Px get() = _badgeMargin
      set(@Dp value) {
        _badgeMargin = context.dp2Px(value)
      }

    @Px
    private var _badgePaddingLeft: Int = context.dp2Px(6)

    var badgePaddingLeft: Int
      @Px get() = _badgePaddingLeft
      set(@Dp value) {
        _badgePaddingLeft = context.dp2Px(value)
      }

    @Px
    private var _badgePaddingTop: Int = context.dp2Px(2)

    var badgePaddingTop: Int
      @Px get() = _badgePaddingTop
      set(@Dp value) {
        _badgePaddingTop = context.dp2Px(value)
      }

    @Px
    private var _badgePaddingRight: Int = context.dp2Px(6)

    var badgePaddingRight: Int
      @Px get() = _badgePaddingRight
      set(@Dp value) {
        _badgePaddingRight = context.dp2Px(value)
      }

    @Px
    private var _badgePaddingBottom: Int = context.dp2Px(2)

    var badgePaddingBottom: Int
      @Px get() = _badgePaddingBottom
      set(@Dp value) {
        _badgePaddingBottom = context.dp2Px(value)
      }

    @Px
    private var _badgeRadius: Int = context.dp2Px(16)

    var badgeRadius: Int
      @Px get() = _badgeRadius
      set(@Dp value) {
        _badgeRadius = context.dp2Px(value)
      }

    @JvmField
    var badgeGravity: Int = Gravity.CENTER

    @JvmField
    var badgeAnimation: BadgeAnimation = BadgeAnimation.NONE

    @JvmField
    var badgeAnimationInterpolator: BadgeAnimationInterpolator = BadgeAnimationInterpolator.NORMAL

    @JvmField
    var badgeDuration: Long = 300L

    /** sets a background drawable of the badge */
    fun setBadge(value: Drawable?) = apply { this.badge = value }

    /** sets the content of the badge. */
    fun setBadgeText(value: CharSequence) = apply { this.badgeText = value }

    /** sets the content of the badge using string resource. */
    fun setBadgeText(@StringRes value: Int) = apply { this.badgeText = context.getString(value) }

    /** sets the text color of the badge. */
    fun setBadgeTextColor(@ColorInt value: Int) = apply { this.badgeTextColor = value }

    /** sets the text color of the badge using resource. */
    fun setBadgeTextColorRes(@ColorRes value: Int) = apply { this.badgeTextColor = context.contextColor(value) }

    /** sets the size of the badge. */
    fun setBadgeTextSize(@Sp value: Float) = apply { this.badgeTextSize = value }

    /** sets the color of the badge. */
    fun setBadgeColor(@ColorInt value: Int) = apply { this.badgeColor = value }

    /** sets the color of the badge using resource. */
    fun setBadgeColorRes(@ColorRes value: Int) = apply { this.badgeColor = context.contextColor(value) }

    /** sets the [Typeface] of the badge. */
    fun setBadgeStyle(value: Int) = apply { this.badgeStyle = value }

    /** sets the [Typeface] of the badge. */
    fun setBadgeTypeface(value: Typeface?) = apply { this.badgeTypeface = value }

    /** sets the margin of the badge. */
    fun setBadgeMargin(@Dp value: Int) = apply { this.badgeMargin = value }

    /** sets the padding of the badge. */
    fun setBadgePadding(@Dp value: Int) = apply {
      this.badgePaddingLeft = context.dp2Px(value)
      this.badgePaddingTop = context.dp2Px(value)
      this.badgePaddingRight = context.dp2Px(value)
      this.badgePaddingBottom = context.dp2Px(value)
    }

    /** sets the left padding of the badge. */
    fun setBadgePaddingLeft(@Dp value: Int) = apply { this.badgePaddingLeft = context.dp2Px(value) }

    /** sets the top padding of the badge. */
    fun setBadgePaddingTop(@Dp value: Int) = apply { this.badgePaddingTop = context.dp2Px(value) }

    /** sets the right padding of the badge. */
    fun setBadgePaddingRight(@Dp value: Int) = apply { this.badgePaddingRight = context.dp2Px(value) }

    /** sets the bottom padding of the badge. */
    fun setBadgePaddingBottom(@Dp value: Int) = apply { this.badgePaddingBottom = context.dp2Px(value) }

    /** sets the radius of the badge. */
    fun setBadgeRadius(@Dp value: Int) = apply { this.badgeRadius = context.dp2Px(value) }

    /** sets gravity of the badge. */
    fun setBadgeGravity(value: Int) = apply { this.badgeGravity = value }

    /** sets an animation of the badge. */
    fun setBadgeAnimation(value: BadgeAnimation) = apply { this.badgeAnimation = value }

    /** sets an badge animation interpolator of the badge. */
    fun setBadgeAnimationInterpolator(value: BadgeAnimationInterpolator) = apply {
      this.badgeAnimationInterpolator = value
    }

    /** sets a duration of the badge. */
    fun setBadgeDuration(value: Long) = apply { this.badgeDuration = value }

    fun build() = BadgeForm(
      badge, badgeText, badgeStyle, badgeTypeface, badgeGravity, badgeDuration,
      badgeAnimation, badgeAnimationInterpolator, badgeTextColor, badgeTextSize,
      badgeColor, _badgeMargin, badgePaddingLeft, badgePaddingTop, badgePaddingRight,
      badgePaddingBottom, badgeRadius
    )
  }
}
