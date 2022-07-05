package com.splanes.overlay.domain.model.extensions


import android.graphics.Color
import androidx.annotation.ColorInt
import com.splanes.overlay.domain.model.OverlayColor
import kotlin.reflect.KProperty

fun OverlayColor.Companion.of(hex: String): OverlayColor =
  when {
    hex.count() !in 6..7 -> throw IllegalArgumentException("Hex color provided value is not valid.")
    !hex.startsWith("#") -> "#$hex"
    else -> hex
  }.let { color -> OverlayColor.Custom(color) }

@ColorInt
operator fun OverlayColor.getValue(any: Any?, property: KProperty<*>): Int =
  runCatching { Color.parseColor(hex) }.getOrDefault(Color.BLACK)