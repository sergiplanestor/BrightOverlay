package com.splanes.commons.domain.errors.model

import android.os.Parcelable
import com.splanes.commons.domain.errors.extensions.ERROR_MESSAGE
import com.splanes.commons.domain.errors.extensions.NoName
import com.splanes.commons.tools.utils.collections.then
import com.splanes.commons.tools.utils.primitive.filterValid

/*
 * Created on 29/06/2022 at 23:49
 * @author Sergi Planes
 * @since 1.0.0
 */
abstract class KnownThrowable(
    open val type: String? = null,
    open val name: String? = this::class.simpleName ?: KnownThrowable.NoName,
    open val description: String? = null,
    open val throwable: Throwable? = null
) : Throwable(msgOf(type, name, description, throwable), throwable), Parcelable {
    companion object
}

private fun msgOf(type: String?, name: String?, description: String?, cause: Throwable?): String =
    listOf(type, name, description).filterValid().then { (t, n, d) ->
        String.format(ERROR_MESSAGE, t, n, d, cause?.message.toString())
    }
