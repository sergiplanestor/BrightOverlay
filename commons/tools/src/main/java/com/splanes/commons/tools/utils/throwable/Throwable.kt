package com.splanes.commons.tools.utils.throwable

/*
 * Created on 04/07/2022 at 21:07
 * @author Sergi Planes
 * @since 1.0.0
 */

fun Throwable?.orRuntime(message: String? = null): Throwable = this ?: RuntimeException(message)
