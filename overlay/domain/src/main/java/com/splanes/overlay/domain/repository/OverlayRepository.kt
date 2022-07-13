package com.splanes.overlay.domain.repository

import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.model.OverlayVisibility


interface OverlayRepository {
    suspend fun lastState(): OverlayState?
    suspend fun updateState(state: OverlayState)
}
