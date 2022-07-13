package com.splanes.commons.data.datasource

import android.content.SharedPreferences
import androidx.core.content.edit
import com.splanes.commons.tools.utils.primitive.takeUnlessMin
import com.splanes.commons.tools.utils.primitive.takeUnlessNaN

/*
 * Created on 05/07/2022 at 18:41
 * @author Sergi Planes
 * @since 1.0.0
 */

inline fun <reified T> SharedPreferences.find(key: String): T? =
    when (T::class) {
        String::class -> getString(key, null)
        Int::class -> getInt(key, Int.MIN_VALUE).takeUnlessMin()
        Float::class -> getFloat(key, Float.NaN).takeUnlessNaN()
        Double::class -> getFloat(key, Float.NaN).takeUnlessNaN()
        Long::class -> getLong(key, Long.MIN_VALUE).takeUnlessMin()
        Boolean::class -> getBoolean(key, false)
        else -> null
    } as T

fun <T> SharedPreferences.insertOrUpdate(key: String, value: T) = edit {
    when (value) {
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Float -> putFloat(key, value)
        is Double -> putFloat(key, value.toFloat())
        is Long -> putLong(key, value)
        is Boolean -> putBoolean(key, value)
        else -> throw RuntimeException("Non supported type yet.")
    }
}