package com.splanes.overlay.data.repository

import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.model.OverlayVisibility
import com.splanes.overlay.domain.repository.OverlayRepository
import javax.inject.Inject

/*
 * Created on 05/07/2022 at 0:27
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayRepositoryImpl @Inject constructor(
    inMemoryDataSource,
    cacheDataSource
) : OverlayRepository {

    override suspend fun findCurrentState(): OverlayState {
        TODO("Not yet implemented")
    }

    override suspend fun saveState(
        visibility: OverlayVisibility,
        opacity: OverlayOpacity,
        color: OverlayColor
    ): OverlayState {
        TODO("Not yet implemented")
    }

    override suspend fun updateState(update: suspend OverlayState.() -> OverlayState): OverlayState {
        TODO("Not yet implemented")
    }
}