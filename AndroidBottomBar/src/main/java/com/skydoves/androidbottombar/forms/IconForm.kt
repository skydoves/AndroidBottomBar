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
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import com.skydoves.androidbottombar.annotations.Dp
import com.skydoves.androidbottombar.extensions.contextColor
import com.skydoves.androidbottombar.extensions.dp2Px
import com.skydoves.androidbottombar.extensions.resourceDrawable

@DslMarker
annotation class IconFormDsl

/** creates an instance of [IconForm] from [IconForm.Builder] using kotlin dsl. */
@IconFormDsl
inline fun iconForm(context: Context, block: IconForm.Builder.() -> Unit): IconForm.Builder =
  IconForm.Builder(context).apply(block)

/**
 * IconForm is an attribute class that has icon attributes
 * for customizing menu item icons easily.
 */
data class IconForm(private val builder: Builder) {

  val icon = builder.icon

  @Px
  val iconSize = builder.iconSize

  @ColorInt
  val iconColor = builder.iconColor

  /** Builder class for [IconForm]. */
  @IconFormDsl
  data class Builder(private val context: Context) {

    @JvmField
    var icon: Drawable? = null

    @Px
    @JvmField
    var iconSize: Int = context.dp2Px(28)

    @ColorInt
    @JvmField
    var iconColor: Int = Color.WHITE

    /** sets the [Drawable] of the icon. */
    fun setIcon(value: Drawable?) = apply { this.icon = value }

    /** sets the [Drawable] of the icon using resource. */
    fun setIcon(@DrawableRes value: Int) = apply {
      this.icon = context.resourceDrawable(value)
    }

    /** sets the size of the icon. */
    fun setIconSize(@Dp value: Int) = apply { this.iconSize = context.dp2Px(value) }

    /** sets the color of the icon. */
    fun setIconColor(@ColorInt value: Int) = apply { this.iconColor = value }

    /** sets the color of the icon using resource */
    fun setIconColorRes(@ColorRes value: Int) = apply {
      this.iconColor = context.contextColor(value)
    }

    fun build() = IconForm(this)
  }
}
