package com.splanes.commons.domain.infrastructure

import com.splanes.commons.domain.errors.handler.AppThrowableHandler
import com.splanes.commons.domain.errors.handler.KnownThrowableHandler
import com.splanes.commons.domain.errors.handler.generic.GenericThrowableHandler
import com.splanes.commons.domain.errors.model.GenericKnownThrowable
import com.splanes.commons.domain.errors.model.KnownThrowable
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

/*
 * Created on 02/07/2022 at 23:42
 * @author Sergi Planes
 * @since 1.0.0
 */

@Module
@InstallIn(SingletonComponent::class) // TODO: Check this component: https://dagger.dev/hilt/components
abstract class KnownThrowableHandlerModule {

    @Binds
    abstract fun principalHandler(appHandler: AppThrowableHandler): KnownThrowableHandler.Principal

    @Binds
    @Named("ThrowableHandler.Generic")
    abstract fun handlerGeneric(impl: GenericThrowableHandler) : KnownThrowableHandler.Handler<GenericKnownThrowable>
}

@Module
@InstallIn(SingletonComponent::class)
object PartialThrowableHandlerModule {

    @Provides
    @Named("KnownThrowableHandlerList")
    fun partialThrowableHandlerList(
        @Named("ThrowableHandler.Generic") generic: KnownThrowableHandler.Handler<GenericKnownThrowable>,
    ): List<KnownThrowableHandler.Handler<KnownThrowable>> =
        listOf(
            generic,
        )

    @Provides
    fun principalThrowableHandler(
        @Named("KnownThrowableHandlerList") list: List<KnownThrowableHandler.Handler<KnownThrowable>>,
    ): AppThrowableHandler =
        AppThrowableHandler(handlers = list)
}