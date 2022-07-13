package com.splanes.overlay.data.infrastructure.di

import com.splanes.overlay.data.repository.OverlayDataRepository
import com.splanes.overlay.domain.repository.OverlayRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
 * Created on 05/07/2022 at 19:06
 * @author Sergi Planes
 * @since 1.0.0
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun overlayRepository(impl: OverlayDataRepository) : OverlayRepository
}