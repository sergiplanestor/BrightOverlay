package com.splanes.overlay.ui.utils

import androidx.compose.ui.graphics.Color

/*
 * Created on 10/07/2022 at 10:39
 * @author Sergi Planes
 * @since 1.0.0
 */
 
enum class OverlayColors(val colorName: String, val value: Long) {
    Black(colorName = "Black",value = 0xFF000000),
    Gray(colorName = "Gray",value = 0xFF212121),
    DarkGray(colorName = "Gray 1",value = 0xFF202020),
    LightBlueGray(colorName = "Blue",value = 0xFF263238),
    BlueGray(colorName = "Blue 1",value = 0xFF1f292e),
    DarkBlueGray(colorName = "Blue 2",value = 0xFF151b1e);
    companion object
}

fun OverlayColors.toColor(): Color =
    Color(this.value)

fun OverlayColors.Companion.of(color: Color): OverlayColors =
    OverlayColors.values().find { c -> c.value == color.value.toLong() } ?: OverlayColors.Black

fun OverlayColors.Companion.items(): List<OverlayColors> =
    OverlayColors.values().toList()

fun OverlayColors.Companion.colors(): List<Color> =
    OverlayColors.items().map { it.toColor() }