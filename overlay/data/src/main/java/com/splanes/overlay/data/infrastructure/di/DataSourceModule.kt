package com.splanes.overlay.data.infrastructure.di

import com.splanes.overlay.data.datasource.OverlayDataSource
import com.splanes.overlay.data.datasource.OverlayDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
 * Created on 05/07/2022 at 19:05
 * @author Sergi Planes
 * @since 1.0.0
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun overlayDataSource(impl: OverlayDataSourceImpl): OverlayDataSource
}