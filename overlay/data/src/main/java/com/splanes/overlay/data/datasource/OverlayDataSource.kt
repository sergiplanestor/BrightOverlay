package com.splanes.overlay.data.datasource

import com.splanes.overlay.data.entity.OverlayStateEntity

/*
 * Created on 05/07/2022 at 2:00
 * @author Sergi Planes
 * @since 1.0.0
 */

interface OverlayDataSource {
    suspend fun persist(entity: OverlayStateEntity)
    suspend fun fetch(): OverlayStateEntity?
}