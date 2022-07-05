package com.splanes.commons.domain.errors.model

import kotlinx.parcelize.Parcelize

/*
 * Created on 30/06/2022 at 0:37
 * @author Sergi Planes
 * @since 1.0.0
 */

sealed class GenericKnownThrowable(
    override val name: String?,
    override val description: String?,
    override val throwable: Throwable?
) : KnownThrowable(
    type = GenericKnownThrowable::class.simpleName,
    name = name,
    description = description,
    throwable = throwable
) {

    @Parcelize
    data class TaskTimeout(
        override val name: String?,
        override val description: String?,
        override val throwable: Throwable? = null
    ) : GenericKnownThrowable(TaskTimeout::class.simpleName, description, throwable)
}
