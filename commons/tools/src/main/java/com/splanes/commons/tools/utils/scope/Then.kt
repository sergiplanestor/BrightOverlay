package com.splanes.commons.tools.utils.scope

/*
 * Created on 04/07/2022 at 22:50
 * @author Sergi Planes
 * @since 1.0.0
 */

fun <T, R> T.doThenOrElse(predicate: Boolean, default: R, action: T.() -> R): R = if (predicate) {
    action()
} else {
    default
}

fun <T> T.doThenOrThis(predicate: Boolean, action: T.() -> T): T =
    doThenOrElse(predicate, default = null, action) ?: this

fun <T, R> T?.doThenNotNull(action: T.() -> R?): R? =
    this?.doThen(action)

fun <T, R> T.doThen(action: T.() -> R): R =
    run(action)

infix fun <T, R> T.then(action: (T) -> R): R =
    run(action)

infix fun <T, R> T?.thenOrNull(action: (T) -> R?): R? =
    doThenNotNull { action(this) }
