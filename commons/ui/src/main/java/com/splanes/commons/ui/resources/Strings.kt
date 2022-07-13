package com.splanes.commons.ui.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import java.util.ResourceBundle

/*
 * Created on 10/07/2022 at 9:41
 * @author Sergi Planes
 * @since 1.0.0
 */

@Composable
inline fun stringOf(id: () -> Int): String = stringResource(id = id())

@Composable
fun <T : Any> T.stringOf(id: String): String =
    stringOf {
        val context = LocalContext.current.packageResourcePath
        this::class.java.classLoader?.loadClass("${context}.R")
            ?.classes?.find { c -> c.simpleName.contains("string") }
            ?.fields?.find { f -> f.name == id }
            ?.getInt(null) ?: throw RuntimeException()
    }