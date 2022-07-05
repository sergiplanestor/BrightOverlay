package com.splanes.brightoverlay.domain.schedule.model

import android.os.Parcelable

sealed interface ScheduleOption : Parcelable {
  interface Start : ScheduleOption
  interface End : ScheduleOption
  interface Any : Start, End
  
  companion object
}