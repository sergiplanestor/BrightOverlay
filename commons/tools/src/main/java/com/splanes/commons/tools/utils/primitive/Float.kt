package com.splanes.commons.tools.utils.primitive


/*
 * Created on 05/07/2022 at 21:44
 * @author Sergi Planes
 * @since 1.0.0
 */

inline val Float.Companion.min get() = MIN_VALUE
inline val Float.Companion.max get() = MAX_VALUE
inline val Float.Companion.zero get() = 0f
inline val Float.Companion.negative get() = -1f

fun Float?.orMin(): Float = this ?: Float.min
fun Float?.orMax(): Float = this ?: Float.max
fun Float?.orZero(): Float = this ?: Float.zero
fun Float?.orNegative(): Float = this ?: Float.negative
fun Float?.orNaN(): Float = this ?: Float.NaN

fun Float.isMin(): Boolean = this == Float.min
fun Float.isMax(): Boolean = this == Float.max
fun Float.isZero(): Boolean = this == Float.zero
fun Float.isNegative(): Boolean = this == Float.negative

fun Float.takeIfMin(): Float? = takeIf { isMin() }
fun Float.takeIfMax(): Float? = takeIf { isMax() }
fun Float.takeIfNaN(): Float? = takeIf { isNaN() }
fun Float.takeUnlessMin(): Float? = takeUnless { isMin() }
fun Float.takeUnlessMax(): Float? = takeUnless { isMax() }
fun Float.takeUnlessNaN(): Float? = takeUnless { isNaN() }