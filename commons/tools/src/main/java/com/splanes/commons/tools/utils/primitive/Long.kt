package com.splanes.commons.tools.utils.primitive


/*
 * Created on 05/07/2022 at 21:44
 * @author Sergi Planes
 * @since 1.0.0
 */

inline val Long.Companion.min get() = MIN_VALUE
inline val Long.Companion.max get() = MIN_VALUE
inline val Long.Companion.zero get() = 0L
inline val Long.Companion.negative get() = -1L

fun Long?.orMin(): Long = this ?: Long.min
fun Long?.orMax(): Long = this ?: Long.max
fun Long?.orZero(): Long = this ?: Long.zero
fun Long?.orNegative(): Long = this ?: Long.negative

fun Long.isMin(): Boolean = this == Long.min
fun Long.isMax(): Boolean = this == Long.max
fun Long.isZero(): Boolean = this == Long.zero
fun Long.isNegative(): Boolean = this == Long.negative

fun Long.takeIfMin(): Long? = takeIf { isMin() }
fun Long.takeIfMax(): Long? = takeIf { isMax() }
fun Long.takeUnlessMin(): Long? = takeUnless { isMin() }
fun Long.takeUnlessMax(): Long? = takeUnless { isMax() }