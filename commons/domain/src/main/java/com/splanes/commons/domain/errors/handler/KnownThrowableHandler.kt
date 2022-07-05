package com.splanes.commons.domain.errors.handler

import com.splanes.commons.domain.errors.model.KnownThrowable
import com.splanes.brightoverlay.tools.base.primitive.orFalse
import kotlin.reflect.KClass

/*
 * Created on 30/06/2022 at 0:55
 * @author Sergi Planes
 * @since 1.0.0
 */

sealed interface KnownThrowableHandler<in T : Throwable, out K : KnownThrowable> {

    fun handleOrNull(throwable: T?): K?
    fun handleOrThrow(throwable: T?): K

    interface Principal : KnownThrowableHandler<Throwable, KnownThrowable> {
        val handlers: List<Handler<KnownThrowable>>
        fun handlerOf(throwable: KnownThrowable): Handler<*>? = handlers.find { it.isHandled(throwable) }
    }

    interface Handler<out O : KnownThrowable> : KnownThrowableHandler<KnownThrowable, O> {
        fun isHandled(throwable: KnownThrowable): Boolean =
            this::class.typeParameters.any { param -> (param as? KClass<*>)?.isInstance(throwable).orFalse() }
    }
}