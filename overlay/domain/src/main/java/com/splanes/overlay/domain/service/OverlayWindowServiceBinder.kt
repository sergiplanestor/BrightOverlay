package com.splanes.overlay.domain.service

import android.os.Binder

/*
 * Created on 10/07/2022 at 13:35
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayWindowServiceBinder internal constructor(val service: OverlayWindowService): Binder()