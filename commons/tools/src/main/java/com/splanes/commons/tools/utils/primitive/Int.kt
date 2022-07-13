package com.splanes.commons.tools.utils.primitive


/*
 * Created on 05/07/2022 at 21:44
 * @author Sergi Planes
 * @since 1.0.0
 */

inline val Int.Companion.min get() = MIN_VALUE
inline val Int.Companion.max get() = MAX_VALUE
inline val Int.Companion.zero get() = 0
inline val Int.Companion.negative get() = -1

fun Int?.orMin(): Int = this ?: Int.min
fun Int?.orMax(): Int = this ?: Int.max
fun Int?.orZero(): Int = this ?: Int.zero
fun Int?.orNegative(): Int = this ?: Int.negative

fun Int.isMin(): Boolean = this == Int.min
fun Int.isMax(): Boolean = this == Int.max
fun Int.isZero(): Boolean = this == Int.zero
fun Int.isNegative(): Boolean = this == Int.negative

fun Int.takeIfMin(): Int? = takeIf { isMin() }
fun Int.takeIfMax(): Int? = takeIf { isMax() }
fun Int.takeUnlessMin(): Int? = takeUnless { isMin() }
fun Int.takeUnlessMax(): Int? = takeUnless { isMax() }