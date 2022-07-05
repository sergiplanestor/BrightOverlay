package com.splanes.brightoverlay.tools.base.primitive

/*
 * Created on 03/07/2022 at 1:45
 * @author Sergi Planes
 * @since 1.0.0
 */

fun String?.isNotNullOrBlank(): Boolean = !isNullOrBlank()

fun List<String?>.filterValid(): List<String> = mapNotNull { s -> s.takeIf { s.isNotNullOrBlank() } }

fun <T> List<String?>.withValid(action: (List<String>) -> T): T = with(filterValid(), action)