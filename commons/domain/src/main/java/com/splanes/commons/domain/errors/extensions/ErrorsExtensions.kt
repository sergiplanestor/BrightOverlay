package com.splanes.commons.domain.errors.extensions

import com.splanes.commons.domain.errors.handler.KnownThrowableHandler
import com.splanes.commons.domain.errors.model.KnownThrowable

/*
 * Created on 29/06/2022 at 21:06
 * @author Sergi Planes
 * @since 1.0.0
 */

internal const val ERROR_MESSAGE = "\n" +
        "<<< ERROR <<<" + "\n\t" +
        "Name: `%1\$s`" + "\n\t" +
        "Type: `%2\$s`" + "\n\t" +
        "Message: `%3\$s`" + "\n\t" +
        "--- Cause ---" + "\n\t" +
        "`%4\$s`" + "\n\t" +
        "---" + "\n" +
        ">>> ERROR >>>" + "\n"

val KnownThrowable.Companion.NoName
    get() = "No-Name"

val KnownThrowable.Companion.Unknown
    get() = "Unknown"

internal inline fun <reified T : KnownThrowable> KnownThrowableHandler.Handler<T>.isThrowableTypeHandled(throwable: Throwable?): Boolean =
    T::class.isInstance(throwable)

internal inline fun <reified T : KnownThrowable> KnownThrowableHandler.Handler<T>.takeIfKnown(
    throwable: Throwable?,
    crossinline action: (error: T) -> KnownThrowable = { it }
): KnownThrowable? =
    (throwable as? T)?.let(action)