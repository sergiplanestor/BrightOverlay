package com.splanes.brightoverlay.domain.service

import com.splanes.brightoverlay.domain.brightconfig.model.BrightConfig
import com.splanes.brightoverlay.domain.overlay.model.OverlayColor
import com.splanes.brightoverlay.domain.overlay.model.OverlayOpacity
import com.splanes.brightoverlay.domain.overlay.model.OverlayVisibility
import com.splanes.brightoverlay.domain.overlay.repository.OverlayRepository
import com.splanes.brightoverlay.domain.schedule.model.ScheduleOption
import com.splanes.brightoverlay.domain.schedule.model.extensions.now
import com.splanes.brightoverlay.domain.schedule.model.extensions.forever
import com.splanes.brightoverlay.domain.schedule.repository.ScheduleRepository

interface BrightOverlayService {
  
  val overlayRepository: OverlayRepository
  
  val scheduleRepository: ScheduleRepository
  
  suspend fun findConfig()
  
  suspend fun saveConfig(
    visibility: OverlayVisibility = OverlayVisibility.Visible,
    opacity: OverlayOpacity = OverlayOpacity.Medium,
    color: OverlayColor = OverlayColor.Black,
    startsOn: ScheduleOption.Start = ScheduleOption.now(),
    endsOn: ScheduleOption.End = ScheduleOption.forever()
  ): BrightConfig
  
  suspend fun updateConfig(update: suspend BrightConfig.() -> BrightConfig): BrightConfig
  
  suspend fun removeConfig(): Boolean
  
  suspend fun enable()
  
  suspend fun disable()
  
  suspend fun updateSchedule()
}