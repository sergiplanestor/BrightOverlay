package com.splanes.brightoverlay.domain.service

import arrow.core.Either
import com.splanes.brightoverlay.domain.brightconfig.model.BrightConfig
import com.splanes.brightoverlay.domain.overlay.repository.OverlayRepository
import com.splanes.brightoverlay.domain.schedule.repository.ScheduleRepository
import javax.inject.Inject

class BrightOverlayServiceImpl @Inject constructor(
    override val overlayRepository: OverlayRepository,
    override val scheduleRepository: ScheduleRepository
) : BrightOverlayService {

    override suspend fun findConfig() {
        TODO("Not yet implemented")
    }

    override suspend fun saveConfig(config: BrightConfig): BrightConfig = with(config) {
        overlayRepository.
    }

    override suspend fun updateConfig() {
        TODO("Not yet implemented")
    }

    override suspend fun removeConfig() {
        TODO("Not yet implemented")
    }

    override suspend fun enable() {
        TODO("Not yet implemented")
    }

    override suspend fun disable() {
        TODO("Not yet implemented")
    }

    override suspend fun updateSchedule() {
        TODO("Not yet implemented")
    }
}
