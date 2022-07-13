package com.splanes.overlay.domain.usecase

import com.splanes.commons.domain.usecase.UseCase
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.repository.OverlayRepository
import com.splanes.overlay.domain.service.OverlayWindowService
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

/*
 * Created on 10/07/2022 at 15:10
 * @author Sergi Planes
 * @since 1.0.0
 */

class UpdateStateUseCase @Inject constructor(
    private val repository: OverlayRepository
) : UseCase<UpdateStateUseCase.Request, Unit>() {

    suspend operator fun invoke(service: OverlayWindowService, state: OverlayState) = invoke(Request(service, state))

    override suspend fun execute(params: Request) {
        withContext(Dispatchers.Main) { params.service.updateOverlayState(params.state) }
        repository.updateState(params.state)
    }

    @Parcelize
    data class Request(val service: @RawValue OverlayWindowService, val state: OverlayState): UseCase.Request
}