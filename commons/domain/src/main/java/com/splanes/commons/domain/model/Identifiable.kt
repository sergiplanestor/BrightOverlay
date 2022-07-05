package com.splanes.commons.domain.model

/*
 * Created on 05/07/2022 at 0:42
 * @author Sergi Planes
 * @since 1.0.0
 */

interface Identifiable<T : Any> {
    val id: T
}