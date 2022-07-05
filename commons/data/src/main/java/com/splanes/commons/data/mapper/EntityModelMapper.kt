package com.splanes.commons.data.mapper

/*
 * Created on 05/07/2022 at 2:07
 * @author Sergi Planes
 * @since 1.0.0
 */

interface EntityModelMapper<Model, Entity> {
    fun modelOf(entity: Entity): Model
    fun entityOf(model: Model): Entity
}