package com.splanes.brightoverlay.domain.schedule.model.extensions

import com.splanes.brightoverlay.domain.schedule.model.ScheduleOption
import com.splanes.brightoverlay.domain.schedule.model.ScheduleOptionImpl
import java.util.concurrent.TimeUnit

fun ScheduleOption.Companion.now(): ScheduleOption.Start =
  ScheduleOptionImpl.Immediately

fun ScheduleOption.Companion.forever(): ScheduleOption.End =
  ScheduleOptionImpl.Never

fun ScheduleOption.Companion.at(millis: Long): ScheduleOption.Any =
  ScheduleOptionImpl.Instant(millis)

fun ScheduleOption.Companion.before(amount: Long, unit: TimeUnit): ScheduleOption.Start =
  ScheduleOptionImpl.TimeLapse(amount, unit)

fun ScheduleOption.Companion.after(amount: Long, unit: TimeUnit): ScheduleOption.End =
  ScheduleOptionImpl.TimeLapse(amount, unit)