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

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.Interpolator

/** animates view's x and y scale size. */
internal fun View.animateScale(
  toX: Float,
  toY: Float,
  duration: Long,
  interpolator: Interpolator
): ViewPropertyAnimator {
  return this.animate()
    .scaleX(toX)
    .scaleY(toY)
    .setDuration(duration)
    .setInterpolator(interpolator)
    .withLayer()
}

/** animates view's alpha value. */
internal fun View.animateFade(
  alpha: Float,
  duration: Long,
  interpolator: Interpolator
): ViewPropertyAnimator {
  return this.animate()
    .alpha(alpha)
    .setDuration(duration)
    .setInterpolator(interpolator)
    .withLayer()
}

/** do something block codes after finish animation. */
internal fun Animator.doAfterFinish(block: () -> Unit) {
  this.addListener(object : AnimatorListenerAdapter() {
    override fun onAnimationEnd(animation: Animator?) {
      super.onAnimationEnd(animation)
      block()
    }
  })
}
