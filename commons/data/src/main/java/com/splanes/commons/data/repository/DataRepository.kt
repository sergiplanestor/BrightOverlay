package com.splanes.commons.data.repository

import com.splanes.commons.data.mapper.EntityModelMapper

/*
 * Created on 05/07/2022 at 19:37
 * @author Sergi Planes
 * @since 1.0.0
 */

interface DataRepository {
    fun <Model, Entity, Mapper : EntityModelMapper<Model, Entity>> Entity.toModel(mapper: Mapper): Model =
        mapper.modelOf(this)

    fun <Model, Entity, Mapper : EntityModelMapper<Model, Entity>> Model.toEntity(mapper: Mapper): Entity =
        mapper.entityOf(this)
}