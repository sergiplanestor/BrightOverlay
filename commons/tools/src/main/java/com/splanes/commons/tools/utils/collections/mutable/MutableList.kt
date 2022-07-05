package com.splanes.commons.tools.utils.collections.mutable

import com.splanes.commons.tools.utils.collections.indexOrNull
import com.splanes.commons.tools.utils.scope.isNotNull
import com.splanes.commons.tools.utils.scope.then
import com.splanes.commons.tools.utils.scope.thenOrNull

/*
 * Created on 05/07/2022 at 1:43
 * @author Sergi Planes
 * @since 1.0.0
 */

fun <E> MutableList<E>.remove(matcher: (E) -> Boolean): Boolean =
    find(matcher) thenOrNull
            ::indexOrNull thenOrNull
            ::removeAt then
            { e -> e.isNotNull() }


fun <E> MutableList<E>.removeAll(matcher: (E) -> Boolean): List<E> = this
    .filter(matcher)
    .mapNotNull(::indexOrNull)
    .map(::removeAt)
