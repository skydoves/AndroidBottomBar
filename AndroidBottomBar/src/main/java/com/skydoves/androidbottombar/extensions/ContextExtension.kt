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

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.skydoves.androidbottombar.R
import com.skydoves.androidbottombar.annotations.Dp

/** dp size to px size. */
internal fun Context.dp2Px(@Dp dp: Int): Int {
  val scale = resources.displayMetrics.density
  return (dp * scale).toInt()
}

/** dp size to px size. */
internal fun Context.dp2Px(@Dp dp: Float): Float {
  val scale = resources.displayMetrics.density
  return dp * scale
}

/** gets an accent color. */
internal fun Context.accentColor(): Int {
  val colorAttr: Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    R.attr.colorAccent
  } else {
    resources.getIdentifier("colorAccent", "attr", packageName)
  }
  val outValue = TypedValue()
  theme.resolveAttribute(colorAttr, outValue, true)
  return outValue.data
}

/** gets a color from the resource. */
internal fun Context.contextColor(@ColorRes resource: Int): Int {
  return ContextCompat.getColor(this, resource)
}

/** gets a drawable from the resource. */
internal fun Context.resourceDrawable(@DrawableRes resource: Int): Drawable? {
  return AppCompatResources.getDrawable(this, resource)
}

/** gets a dimension pixel size from dimension resource. */
internal fun Context.dimen(@DimenRes dimenRes: Int): Int {
  return resources.getDimensionPixelSize(dimenRes)
}
