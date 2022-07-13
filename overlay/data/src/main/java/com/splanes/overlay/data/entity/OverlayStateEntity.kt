package com.splanes.overlay.data.entity

import com.google.gson.annotations.SerializedName

/*
 * Created on 10/07/2022 at 17:31
 * @author Sergi Planes
 * @since 1.0.0
 */

data class OverlayStateEntity(
    @SerializedName("overlay_color") val color: Long,
    @SerializedName("overlay_opacity") val opacity: Float
)
