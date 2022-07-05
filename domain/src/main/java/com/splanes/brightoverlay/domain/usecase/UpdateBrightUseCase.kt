package com.splanes.brightoverlay.domain.usecase

import com.splanes.brightoverlay.domain.utils.UseCase
import com.splanes.brightoverlay.domain.brightconfig.model.BrightConfig
import com.splanes.brightoverlay.domain.service.BrightOverlayService
import javax.inject.Inject

class UpdateBrightUseCase @Inject constructor(
  private val repository: BrightOverlayService
) : UseCase<BrightConfig, Boolean>() {
  
  override suspend fun execute(params: BrightConfig): Boolean {
    repository.updateBrightOpacity(params.opacity)
  }
}
