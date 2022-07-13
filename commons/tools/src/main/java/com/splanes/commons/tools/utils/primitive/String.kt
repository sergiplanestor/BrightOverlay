package com.splanes.commons.tools.utils.primitive

import kotlin.text.replaceFirst as replaceLazy

/*
 * Created on 04/07/2022 at 21:08
 * @author Sergi Planes
 * @since 1.0.0
 */

val String.Companion.empty: String
    get() = ""

fun String?.isNotNullOrBlank(): Boolean = !isNullOrBlank()

fun String?.isValid(): Boolean = isNotNullOrBlank()

fun List<String?>.filterValid(): List<String> = mapNotNull { s -> s.takeIf { it.isValid() } }

fun <T> String?.doOnValid(action: String.() -> T): T? = takeIf { it.isValid() }?.action()

fun String.remove(str: String, lazy: Boolean = false, ignoreCase: Boolean = true): String =
    if (lazy) {
        replaceLazy(oldValue = str, newValue = String.empty, ignoreCase)
    } else {
        replace(oldValue = str, newValue = String.empty, ignoreCase)
    }

enum class Joiner(val value: String) {
    None(value = ""),
    Comma(value = ","),
    Break(value = "\n"),
}

fun join(joiners: List<Joiner> = listOf(Joiner.None), vararg values: String): String = buildString {
    values.forEach { s ->
        append(s)
        joiners.map { joiner -> joiner.value }.forEach { joiner -> append(joiner) }
    }
}