package com.splanes.overlay.domain.model.extensions

import com.splanes.overlay.domain.model.OverlayVisibility


fun OverlayVisibility.visible(): Boolean = this == OverlayVisibility.Visible
fun OverlayVisibility.invisible(): Boolean = !visible()
fun OverlayVisibility.disabled(): Boolean = this == OverlayVisibility.Gone
fun OverlayVisibility.enabled(): Boolean = !disabled()
