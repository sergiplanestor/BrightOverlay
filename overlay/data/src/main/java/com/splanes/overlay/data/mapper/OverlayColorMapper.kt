package com.splanes.overlay.data.mapper

import com.splanes.commons.data.mapper.EntityModelMapper
import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayVisibility
import javax.inject.Inject

/*
 * Created on 05/07/2022 at 2:13
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayColorMapper @Inject constructor() : EntityModelMapper<OverlayColor, String> {

    override fun modelOf(entity: String): OverlayColor {
        TODO("Not yet implemented")
    }

    override fun entityOf(model: OverlayColor): String {
        TODO("Not yet implemented")
    }
}