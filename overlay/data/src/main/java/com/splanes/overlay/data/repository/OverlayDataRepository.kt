package com.splanes.overlay.data.repository

import com.splanes.commons.data.mapper.EntityModelMapper
import com.splanes.commons.data.repository.DataRepository
import com.splanes.overlay.data.datasource.OverlayDataSource
import com.splanes.overlay.data.entity.OverlayStateEntity
import com.splanes.overlay.domain.model.OverlayColor
import com.splanes.overlay.domain.model.OverlayOpacity
import com.splanes.overlay.domain.model.OverlayState
import com.splanes.overlay.domain.model.OverlayVisibility
import com.splanes.overlay.domain.repository.OverlayRepository
import javax.inject.Inject

/*
 * Created on 05/07/2022 at 0:27
 * @author Sergi Planes
 * @since 1.0.0
 */

class OverlayDataRepository @Inject constructor(
    private val dataSource: OverlayDataSource,
    private val mapper: EntityModelMapper<OverlayState, OverlayStateEntity>
) : OverlayRepository, DataRepository {

    override suspend fun lastState(): OverlayState? =
        dataSource.fetch()?.run(mapper::modelOf)

    override suspend fun updateState(state: OverlayState) =
        dataSource.persist(state.run(mapper::entityOf))
}