package com.splanes.overlay.domain.service

import com.splanes.overlay.domain.model.OverlayState

/*
 * Created on 10/07/2022 at 13:22
 * @author Sergi Planes
 * @since 1.0.0
 */

interface OverlayWindowService {
    fun show()
    fun hide()
    fun updateOverlayState(state: OverlayState)
}