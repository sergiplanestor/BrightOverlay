package com.splanes.commons.tools.utils.collections

import com.splanes.commons.tools.utils.collections.mutable.remove


/*
 * Created on 05/07/2022 at 0:09
 * @author Sergi Planes
 * @since 1.0.0
 */

fun <E, T> List<E>.then(action: (List<E>) -> T): T = let(action)

fun <E> List<E>.indexOrNull(item: E): Int? = this
    .indexOf(item)
    .takeIf { i -> i != -1 }

fun <E> List<E>.mutate(action: (mutableList: MutableList<E>) -> Unit): List<E> =
    toMutableList().apply(action)

fun <E> List<E>.removeImmutable(matcher: (e: E) -> Boolean): List<E> =
    mutate { mutableList -> mutableList.remove { e -> matcher(e) } }

fun <E> List<E>.removeAllImmutable(matcher: (e: E) -> Boolean): List<E> =
    mutate { mutableList -> mutableList.removeAll { e -> matcher(e) } }
