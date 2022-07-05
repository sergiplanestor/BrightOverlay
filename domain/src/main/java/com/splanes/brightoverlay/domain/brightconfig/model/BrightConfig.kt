package com.splanes.brightoverlay.domain.brightconfig.model

import android.os.Parcelable
import com.splanes.brightoverlay.domain.overlay.model.OverlayState
import com.splanes.brightoverlay.domain.schedule.model.ScheduleConfig
import kotlinx.parcelize.Parcelize

@Parcelize
data class BrightConfig(
    val overlayState: OverlayState,
    val schedule: ScheduleConfig
) : Parcelable
