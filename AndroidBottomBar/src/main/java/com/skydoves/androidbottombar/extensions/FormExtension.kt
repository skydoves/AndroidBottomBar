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

package com.skydoves.androidbottombar.extensions

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import com.skydoves.androidbottombar.forms.BadgeForm
import com.skydoves.androidbottombar.forms.IconForm
import com.skydoves.androidbottombar.forms.TitleForm

/** applies text form attributes to a TextView instance. */
internal fun TextView.applyTitleForm(titleForm: TitleForm) {
  text = titleForm.title
  textSize = titleForm.titleSize
  gravity = titleForm.titleGravity
  setTextColor(titleForm.titleColor)
  titleForm.titleTypeface?.let { typeface = it } ?: setTypeface(typeface, titleForm.titleStyle)
  setPadding(titleForm.titlePadding, titleForm.titlePadding, titleForm.titlePadding, titleForm.titlePadding)
}

/** applies icon form attributes to a ImageView instance. */
internal fun AppCompatImageView.applyIconForm(iconForm: IconForm) {
  iconForm.icon?.let {
    setImageDrawable(it)
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(iconForm.iconColor))
    layoutParams = FrameLayout.LayoutParams(iconForm.iconSize, iconForm.iconSize, Gravity.CENTER)
  }
}

/** applies badge form attributes to a TextView instance. */
internal fun TextView.applyBadgeForm(badgeForm: BadgeForm) {
  text = badgeForm.badgeText
  textSize = badgeForm.badgeTextSize
  gravity = badgeForm.badgeGravity
  setTextColor(badgeForm.badgeTextColor)
  badgeForm.badgeTypeface?.let { typeface = it } ?: setTypeface(typeface, badgeForm.badgeStyle)
  background = badgeForm.badge ?: GradientDrawable().apply {
    setColor(badgeForm.badgeColor)
    cornerRadius = badgeForm.badgeRadius.toFloat()
  }
  setPadding(
    badgeForm.badgePaddingLeft, badgeForm.badgePaddingTop, badgeForm.badgePaddingRight, badgeForm.badgePaddingBottom)
  (layoutParams as ViewGroup.MarginLayoutParams).setMargins(
    badgeForm.badgeMargin, badgeForm.badgeMargin, badgeForm.badgeMargin, badgeForm.badgeMargin)
}
