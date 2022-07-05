package com.splanes.overlay.data.mapper

import com.splanes.commons.data.mapper.EntityModelMapper
import com.splanes.commons.tools.utils.scope.orThrow
import com.splanes.overlay.domain.model.OverlayVisibility
import javax.inject.Inject

/*
 * Created on 05/07/2022 at 2:06
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayVisibilityMapper @Inject constructor() : EntityModelMapper<OverlayVisibility, Int> {

    override fun modelOf(entity: Int): OverlayVisibility =
        when (entity) {
            OverlayVisibility.Visible.ordinal -> OverlayVisibility.Visible
            OverlayVisibility.Invisible.ordinal -> OverlayVisibility.Visible
            OverlayVisibility.Gone.ordinal -> OverlayVisibility.Visible
            else -> null
        } orThrow "Overlay visibility entity value `$entity` is not valid."

    override fun entityOf(model: OverlayVisibility): Int =
        model.ordinal
}