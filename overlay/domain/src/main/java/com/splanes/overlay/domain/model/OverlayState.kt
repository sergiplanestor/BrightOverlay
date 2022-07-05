package com.splanes.overlay.domain.model

import android.os.Parcelable
import com.splanes.overlay.domain.model.OverlayColor
import kotlinx.parcelize.Parcelize

@Parcelize
data class OverlayState(
    val visibility: OverlayVisibility = OverlayVisibility.Visible,
    val opacity: OverlayOpacity = OverlayOpacity.Medium,
    val color: OverlayColor = OverlayColor.Black,
): Parcelable