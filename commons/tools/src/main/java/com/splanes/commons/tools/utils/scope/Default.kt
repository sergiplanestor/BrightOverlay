package com.splanes.commons.tools.utils.scope

import com.splanes.commons.tools.utils.throwable.orRuntime

/*
 * Created on 04/07/2022 at 21:34
 * @author Sergi Planes
 * @since 1.0.0
 */

fun <T> T?.isNull(): Boolean = this == null
fun <T> T?.isNotNull(): Boolean = !isNull()
fun <T> T?.ifNull(action: () -> T): T = this ?: action()

infix fun <T> T?.orElse(action: () -> T): T = ifNull(action)

infix fun <T> T?.orThrow(throwable: Throwable?): T = ifNull { throw throwable.orRuntime() }

infix fun <T> T?.orThrow(message: String): T = this orThrow RuntimeException(message)