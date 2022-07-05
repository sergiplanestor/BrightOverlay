package com.splanes.overlay.domain.usecase.request

import com.splanes.commons.domain.usecase.UseCase
import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.OverlayVisibility
import kotlinx.parcelize.Parcelize

/*
 * Created on 03/07/2022 at 2:30
 * @author Sergi Planes
 * @since 1.0.0
 */
@Parcelize
data class SaveOverlayStateRequest(
    val visibility: OverlayVisibility = OverlayVisibility.Visible,
    val opacity: OverlayOpacity = OverlayOpacity.Medium,
    val color: OverlayColor = OverlayColor.Black
) : UseCase.Request
