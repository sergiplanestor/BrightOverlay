package com.splanes.overlay.domain.usecase

import com.splanes.commons.domain.usecase.UseCase
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.repository.OverlayRepository
import javax.inject.Inject
import kotlinx.parcelize.Parcelize

/*
 * Created on 10/07/2022 at 15:17
 * @author Sergi Planes
 * @since 1.0.0
 */

class FindLastStateUseCase @Inject constructor(
    private val repository: OverlayRepository
) : UseCase<FindLastStateUseCase.Stub, OverlayState?>() {

    suspend operator fun invoke() = invoke(Stub)

    override suspend fun execute(params: Stub): OverlayState? =
        repository.lastState()

    @Parcelize
    object Stub : Request
}