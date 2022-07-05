package com.splanes.commons.data.datasource

/*
 * Created on 05/07/2022 at 0:56
 * @author Sergi Planes
 * @since 1.0.0
 */

interface DataSource<T> {
    @Throws(DataSourceThrowable.IllegalParams::class)
    suspend fun <Params> single(params: Params? = null): T

    @Throws(DataSourceThrowable.IllegalParams::class)
    suspend fun <Params> every(params: Params? = null): List<T>

    @Throws(DataSourceThrowable.IllegalParams::class)
    suspend fun <Params> insert(params: Params? = null): T

    @Throws(DataSourceThrowable.IllegalParams::class)
    suspend fun update(data: T): T

    @Throws(DataSourceThrowable.IllegalParams::class)
    suspend fun <Params> remove(params: Params? = null): Boolean
}