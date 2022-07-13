package com.splanes.overlay.domain.model.extensions

import androidx.annotation.FloatRange
import com.splanes.commons.tools.utils.scope.orThrow
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.OverlayVisibility


fun OverlayVisibility.visible(): Boolean = this == OverlayVisibility.Visible
fun OverlayVisibility.invisible(): Boolean = !visible()
fun OverlayVisibility.disabled(): Boolean = this == OverlayVisibility.Gone
fun OverlayVisibility.enabled(): Boolean = !disabled()
fun OverlayVisibility.Companion.of(value: Int): OverlayVisibility =
    when (value) {
        OverlayVisibility.Visible.ordinal -> OverlayVisibility.Visible
        OverlayVisibility.Invisible.ordinal -> OverlayVisibility.Invisible
        OverlayVisibility.Gone.ordinal -> OverlayVisibility.Gone
        else -> null
    } orThrow "Overlay visibility value `$value` is not valid."
