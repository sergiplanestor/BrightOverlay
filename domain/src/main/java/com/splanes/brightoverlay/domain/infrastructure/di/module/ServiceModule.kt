package com.splanes.brightoverlay.domain.infrastructure.di.module

import com.splanes.brightoverlay.domain.service.BrightOverlayService
import com.splanes.brightoverlay.domain.service.BrightOverlayServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // TODO: Check this component: https://dagger.dev/hilt/components
abstract class ServiceModule {

    @Binds
    abstract fun brightOverlayService(service: BrightOverlayServiceImpl): BrightOverlayService
}
