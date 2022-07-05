package com.splanes.overlay.domain.repository

import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.model.OverlayVisibility


interface OverlayRepository {
    suspend fun findCurrentState(): OverlayState
    suspend fun saveState(visibility: OverlayVisibility, opacity: OverlayOpacity, color: OverlayColor): OverlayState
    suspend fun updateState(update: suspend OverlayState.() -> OverlayState): OverlayState
}
