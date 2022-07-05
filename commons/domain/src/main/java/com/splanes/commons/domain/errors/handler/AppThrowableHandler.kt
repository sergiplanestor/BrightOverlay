package com.splanes.commons.domain.errors.handler

import com.splanes.commons.domain.errors.model.KnownThrowable
import com.splanes.commons.tools.utils.throwable.orRuntime

/*
 * Created on 29/06/2022 at 21:00
 * @author Sergi Planes
 * @since 1.0.0
 */
class AppThrowableHandler(
    override val handlers: List<KnownThrowableHandler.Handler<KnownThrowable>>
) : KnownThrowableHandler.Principal {

    override fun handleOrNull(throwable: Throwable?): KnownThrowable? =
        (throwable as? KnownThrowable)?.let { e ->
            handlerOf(e)?.handleOrNull(e)
        }

    override fun handleOrThrow(throwable: Throwable?): KnownThrowable =
        handleOrNull(throwable) ?: throw throwable.orRuntime()
}