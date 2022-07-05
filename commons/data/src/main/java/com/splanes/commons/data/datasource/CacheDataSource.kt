package com.splanes.commons.data.datasource

import com.splanes.commons.tools.utils.collections.mutable.remove

/*
 * Created on 05/07/2022 at 1:00
 * @author Sergi Planes
 * @since 1.0.0
 */
 
abstract class CacheDataSource<T> {
    private val _source by lazy { mutableListOf<T>() }

    open fun single(matcher: T.() -> Boolean): T =
        every(matcher).first()

    open fun every(matcher: T.() -> Boolean): List<T> =
        _source.filter(matcher)

    open fun insert(data: T): T = data.apply(_source::add)

    open fun remove(data: T): Boolean = _source.remove { e -> e === data && e.toString() == data.toString() }

    fun clear() = _source.clear()

    protected fun <R> withSource(action: List<T>.() -> R) = _source.action()
}