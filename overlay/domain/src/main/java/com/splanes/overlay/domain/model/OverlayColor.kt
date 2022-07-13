package com.splanes.overlay.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class OverlayColor(open val value: Long) : Parcelable {
    @Parcelize
    object Black : OverlayColor(value = 0xFF000000)

    @Parcelize
    object Gray : OverlayColor(value = 0xFF808080)

    @Parcelize
    object DarkGray : OverlayColor(value = 0xFF212121)

    @Parcelize
    object BlueGray : OverlayColor(value = 0xFF263238)

    @Parcelize
    object StealGray : OverlayColor(value = 0xFF71797E)

    @Parcelize
    data class Custom internal constructor(override val value: Long) : OverlayColor(value)

    companion object
}

fun OverlayColor.Companion.default() = listOf(
    OverlayColor.Black,
    OverlayColor.Gray,
    OverlayColor.DarkGray,
    OverlayColor.BlueGray,
    OverlayColor.StealGray,
)

fun OverlayColor.Companion.of(value: Long) = default().find { it.value == value } ?: OverlayColor.Custom(value)