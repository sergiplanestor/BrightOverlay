package com.splanes.overlay.data.infrastructure.di

import com.splanes.commons.data.mapper.EntityModelMapper
import com.splanes.overlay.data.entity.OverlayStateEntity
import com.splanes.overlay.data.mapper.OverlayStateMapper
import com.splanes.overlay.domain.model.OverlayState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
 * Created on 05/07/2022 at 16:08
 * @author Sergi Planes
 * @since 1.0.0
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun overlayStateMapper(mapper: OverlayStateMapper): EntityModelMapper<OverlayState, OverlayStateEntity>

}