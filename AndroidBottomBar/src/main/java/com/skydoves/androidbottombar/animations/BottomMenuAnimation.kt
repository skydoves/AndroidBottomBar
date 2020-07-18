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

package com.skydoves.androidbottombar.animations

import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator

/**
 * BottomMenuAnimation is an enumeration class for
 * animating selected or unselected BottomMenuItemView with an interpolator.
 */
@Suppress("unused")
enum class BottomMenuAnimation(val value: Int) {
  NORMAL(0),
  ACCELERATE(1),
  BOUNCE(2),
  OVERSHOOT(3),
}

/** returns an interpolator from the [BottomMenuAnimation]. */
fun BottomMenuAnimation.getInterpolator(): Interpolator {
  return when (this) {
    BottomMenuAnimation.NORMAL -> LinearInterpolator()
    BottomMenuAnimation.ACCELERATE -> AccelerateInterpolator()
    BottomMenuAnimation.BOUNCE -> BounceInterpolator()
    BottomMenuAnimation.OVERSHOOT -> OvershootInterpolator()
  }
}
