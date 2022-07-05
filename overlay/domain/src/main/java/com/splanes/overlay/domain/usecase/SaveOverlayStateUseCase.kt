package com.splanes.brightoverlay.domain.overlay.usecase

import com.splanes.brightoverlay.domain.overlay.model.OverlayState
import com.splanes.brightoverlay.domain.overlay.repository.OverlayRepository
import com.splanes.overlay.domain.usecase.request.SaveOverlayStateRequest
import com.splanes.brightoverlay.domain.utils.UseCase
import javax.inject.Inject

/**
 *
 * Created on 29/06/2022 at 1:20
 * @author Sergi Planes
 * @since 1.0.0
 */
class SaveOverlayStateUseCase @Inject constructor(
    private val repository: OverlayRepository
) : UseCase<SaveOverlayStateRequest, OverlayState>() {

    override suspend fun execute(params: SaveOverlayStateRequest): OverlayState =
        with(params) {
            repository.saveState(visibility = visibility, opacity = opacity, color = color)
        }
}