package com.splanes.commons.domain.errors.handler.generic

import com.splanes.commons.domain.errors.handler.KnownThrowableHandler
import com.splanes.commons.domain.errors.model.GenericKnownThrowable
import com.splanes.commons.domain.errors.model.KnownThrowable
import javax.inject.Inject

/*
 * Created on 02/07/2022 at 23:40
 * @author Sergi Planes
 * @since 1.0.0
 */

class GenericThrowableHandler @Inject constructor(): KnownThrowableHandler.Handler<GenericKnownThrowable> {

    override fun handleOrNull(throwable: KnownThrowable?): GenericKnownThrowable? {
        TODO("Not yet implemented")
    }

    override fun handleOrThrow(throwable: KnownThrowable?): GenericKnownThrowable {
        TODO("Not yet implemented")
    }
}