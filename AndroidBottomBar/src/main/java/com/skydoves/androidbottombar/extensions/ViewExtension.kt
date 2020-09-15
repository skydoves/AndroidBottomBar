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

import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import com.skydoves.androidbottombar.BottomMenuItemViewConfig
import com.skydoves.androidbottombar.animations.getInterpolator
import com.skydoves.androidbottombar.annotations.Dp

/** dp size to px size. */
internal fun View.dp2Px(@Dp dp: Int) = context.dp2Px(dp)

/** dp size to px size. */
internal fun View.dp2Px(@Dp dp: Float) = context.dp2Px(dp)

/** makes visible or gone a view align the value parameter. */
internal fun View.visible(value: Boolean) {
  if (value) {
    this.visibility = View.VISIBLE
  } else {
    this.visibility = View.GONE
  }
}

/** updates [FrameLayout]'s layout params. */
internal fun ViewGroup.updateLayoutParams(block: ViewGroup.LayoutParams.() -> Unit) {
  layoutParams?.let {
    layoutParams = it.apply { block(this) }
  }
}

/** translate x axis of a view. */
internal fun View.translateX(
  from: Float,
  to: Float,
  config: BottomMenuItemViewConfig
) {
  ValueAnimator.ofFloat(from, to).apply {
    this.duration = config.duration
    this.interpolator = config.animation.getInterpolator()
    addUpdateListener {
      x = it.animatedValue as Float
    }
  }.start()
}

/** translate y axis of a view. */
internal fun View.translateY(
  from: Float,
  to: Float,
  config: BottomMenuItemViewConfig,
  onStart: (View) -> Unit = {},
  onEnd: (View) -> Unit = {}
) {
  startAnimation(
    TranslateAnimation(0f, 0f, from, to).apply {
      this.duration = config.duration
      this.interpolator = config.animation.getInterpolator()
      this.setAnimationListener(
        object : Animation.AnimationListener {
          override fun onAnimationStart(p0: Animation?) = onStart(this@translateY)
          override fun onAnimationEnd(p0: Animation?) = onEnd(this@translateY)
          override fun onAnimationRepeat(p0: Animation?) = Unit
        }
      )
    }
  )
}
