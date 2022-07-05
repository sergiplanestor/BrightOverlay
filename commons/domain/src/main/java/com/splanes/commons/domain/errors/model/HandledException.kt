package com.splanes.commons.domain.errors.model

import android.os.Parcelable
import com.splanes.commons.domain.errors.extensions.ERROR_MESSAGE
import com.splanes.commons.domain.errors.model.HandledException.Generic
import kotlinx.parcelize.Parcelize



sealed class HandledException(
    open val name: String? = null,
    val type: String? = null,
    override val message: String? = null,
    override val cause: Throwable? = null
) : Throwable(
    message = String.format(
        ERROR_MESSAGE,
        name.toString(),
        type.toString(),
        message.toString(),
        cause?.message.toString()
    ),
    cause = cause
), Parcelable {
    sealed class Generic(
        override val name: String?,
        override val message: String? = null,
        override val cause: Throwable? = null
    ) : HandledException(name = name, type = "Generic", message = message, cause = cause)
}

@Parcelize
data class TaskTimeoutException(val task: String? = "Unknown") :
        Generic(
            name = "TaskTimeoutException",
            message = "Task named `$task` was taking more than allowed"
        )
