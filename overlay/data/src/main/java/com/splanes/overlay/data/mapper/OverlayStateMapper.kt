package com.splanes.overlay.data.mapper

import com.splanes.commons.data.mapper.EntityModelMapper
import com.splanes.overlay.data.entity.OverlayStateEntity
import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.model.extensions.of
import com.splanes.overlay.domain.model.of
import javax.inject.Inject

/*
 * Created on 05/07/2022 at 2:13
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayStateMapper @Inject constructor() : EntityModelMapper<OverlayState, OverlayStateEntity> {

    override fun modelOf(entity: OverlayStateEntity): OverlayState =
        OverlayState(
            color = OverlayColor.of(entity.color),
            opacity = OverlayOpacity.of(entity.opacity)
        )

    override fun entityOf(model: OverlayState): OverlayStateEntity =
        OverlayStateEntity(
            color = model.color.value,
            opacity = model.opacity.alpha
        )
}