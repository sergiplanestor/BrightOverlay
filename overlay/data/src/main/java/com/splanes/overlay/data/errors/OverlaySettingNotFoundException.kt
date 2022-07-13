package com.splanes.overlay.data.errors

import com.splanes.commons.domain.errors.model.KnownThrowable
import com.splanes.commons.tools.utils.primitive.empty
import kotlinx.parcelize.Parcelize

/*
 * Created on 05/07/2022 at 19:44
 * @author Sergi Planes
 * @since 1.0.0
 */

@Parcelize
data class OverlaySettingNotFoundException(val setting: String = String.empty) : KnownThrowable(
    type = OverlaySettingNotFoundException::class.simpleName,
    name = setting,
    description = String.format(MSG_SETTING_NOT_FOUND, setting)
)

private const val MSG_SETTING_NOT_FOUND =
    "Requested Overlay setting `%1\$s` has not been found. Seems it hadn't been init yet."