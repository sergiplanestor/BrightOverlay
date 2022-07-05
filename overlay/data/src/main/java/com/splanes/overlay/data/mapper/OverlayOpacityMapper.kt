package com.splanes.overlay.data.mapper

import com.splanes.commons.data.mapper.EntityModelMapper
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.extensions.of
import javax.inject.Inject

/*
 * Created on 05/07/2022 at 2:13
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayOpacityMapper @Inject constructor() : EntityModelMapper<OverlayOpacity, Float> {

    override fun modelOf(entity: Float): OverlayOpacity =
        when (entity) {
            OverlayOpacity.Opaque.alpha -> OverlayOpacity.Opaque
            OverlayOpacity.Medium.alpha -> OverlayOpacity.Medium
            OverlayOpacity.Transparent.alpha -> OverlayOpacity.Transparent
            else -> OverlayOpacity.of(entity)
        }

    override fun entityOf(model: OverlayOpacity): Float =
        model.alpha
}