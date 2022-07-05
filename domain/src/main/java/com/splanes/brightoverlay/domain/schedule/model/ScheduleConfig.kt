package com.splanes.brightoverlay.domain.schedule.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleConfig(
  val startsOn: ScheduleOption.Start = ScheduleOptionImpl.Immediately,
  val endsOn: ScheduleOption.End = ScheduleOptionImpl.Never
) : Parcelable
