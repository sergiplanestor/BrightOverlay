package com.splanes.overlay.data.datasource

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.splanes.commons.data.datasource.find
import com.splanes.commons.data.datasource.insertOrUpdate
import com.splanes.commons.tools.utils.scope.orThrow
import com.splanes.overlay.data.entity.OverlayStateEntity
import com.splanes.overlay.data.errors.OverlaySettingNotFoundException
import javax.inject.Inject

/*
 * Created on 05/07/2022 at 2:00
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayDataSourceImpl @Inject constructor(
    private val prefs: SharedPreferences
) : OverlayDataSource {

    override suspend fun persist(entity: OverlayStateEntity) =
        Gson().toJson(entity).let { e -> prefs.edit { putString(STATE, e) } }

    override suspend fun fetch(): OverlayStateEntity? =
        prefs.getString(STATE, null)?.let { Gson().fromJson(it, OverlayStateEntity::class.java) }

    companion object {
        private const val STATE = "BrightOverlay.prefs.overlay.state"
    }
}