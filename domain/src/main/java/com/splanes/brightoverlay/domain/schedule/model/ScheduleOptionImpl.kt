package com.splanes.brightoverlay.domain.schedule.model

import java.util.concurrent.TimeUnit
import kotlinx.parcelize.Parcelize

internal sealed class ScheduleOptionImpl : ScheduleOption {
  
  @Parcelize
  object Immediately : ScheduleOptionImpl(), ScheduleOption.Start
  
  @Parcelize
  object Never : ScheduleOptionImpl(), ScheduleOption.End
  
  @Parcelize
  data class Instant(val millis: Long) : ScheduleOptionImpl(), ScheduleOption.Any
  
  @Parcelize
  data class TimeLapse(val lapse: Long, val unit: TimeUnit) : ScheduleOptionImpl(), ScheduleOption.Any
}