package com.splanes.overlay.domain.usecase

import com.splanes.commons.domain.usecase.UseCase
import com.splanes.overlay.domain.service.OverlayWindowService
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

/*
 * Created on 10/07/2022 at 13:19
 * @author Sergi Planes
 * @since 1.0.0
 */

class UpdateEnableStateUseCase @Inject constructor() : UseCase<UpdateEnableStateUseCase.Request, Unit>() {

    suspend operator fun invoke(service: OverlayWindowService, enable: Boolean) = invoke(Request(service, enable))

    override suspend fun execute(params: Request) {
        withContext(Dispatchers.Main) {
            if (params.enable) {
                params.service.show()
            } else {
                params.service.hide()
            }
        }
    }

    @Parcelize
    data class Request(val service: @RawValue OverlayWindowService, val enable: Boolean) : UseCase.Request
}