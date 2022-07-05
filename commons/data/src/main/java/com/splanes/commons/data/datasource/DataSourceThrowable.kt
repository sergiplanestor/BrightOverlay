package com.splanes.commons.data.datasource

import com.splanes.commons.domain.errors.model.KnownThrowable
import kotlinx.parcelize.Parcelize

/*
 * Created on 05/07/2022 at 0:52
 * @author Sergi Planes
 * @since 1.0.0
 */

sealed class DataSourceThrowable(
    override val name: String?,
    override val description: String?,
    override val throwable: Throwable?
) : KnownThrowable(
    type = DataSourceThrowable::class.simpleName,
    name = name,
    description = description,
    throwable = throwable
) {

    @Parcelize
    data class IllegalParams(
        override val description: String? = "Provided `params` are not valid.",
        override val throwable: Throwable? = null
    ) : DataSourceThrowable(IllegalParams::class.simpleName, description, throwable)

}

