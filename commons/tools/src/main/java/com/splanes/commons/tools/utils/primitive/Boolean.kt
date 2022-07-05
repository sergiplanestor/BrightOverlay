package com.splanes.commons.tools.utils.primitive

import kotlin.text.toBoolean as toBool

/*
 * Created on 04/07/2022 at 21:08
 * @author Sergi Planes
 * @since 1.0.0
 */

fun <T> Boolean.doOnTrue(action: () -> T): T? = action.takeIf { this }?.invoke()
fun <T> Boolean.doOnFalse(action: () -> T): T? = action.takeIf { !this }?.invoke()

fun Boolean?.orElse(action: () -> Boolean): Boolean = this ?: action()
fun Boolean?.orTrue(): Boolean = orElse { true }
fun Boolean?.orFalse(): Boolean = orElse { false }

fun <T : Any> T?.toBoolean(default: Boolean = false): Boolean =
    runCatching {
        when(this) {
            is String -> toBool()
            is Number -> this as Number == 1
            else -> throw RuntimeException("")
        }
    }.getOrDefault(default)
