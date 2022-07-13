package com.splanes.overlay.domain.model.extensions

import androidx.annotation.FloatRange
import com.splanes.overlay.domain.model.OverlayOpacity

val OverlayOpacity.Companion.MaxOpacity: Float get() = .9f
val OverlayOpacity.Companion.MinOpacity: Float get() = .1f
fun OverlayOpacity.Companion.of(@FloatRange(from = 0.0, to = 1.0) alpha: Float): OverlayOpacity =
  when (alpha) {
    OverlayOpacity.Opaque.alpha -> OverlayOpacity.Opaque
    OverlayOpacity.Medium.alpha -> OverlayOpacity.Medium
    OverlayOpacity.Transparent.alpha -> OverlayOpacity.Transparent
    else -> OverlayOpacity.Value(alpha.coerceAtLeast(MinOpacity).coerceAtMost(MaxOpacity))
  }
