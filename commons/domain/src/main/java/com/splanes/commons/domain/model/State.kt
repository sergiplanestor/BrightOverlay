package com.splanes.commons.domain.model

import com.splanes.commons.domain.errors.model.KnownThrowable

sealed class State<out E : KnownThrowable, out T> {
    data class Ok<out T>(val result: T) : State<Nothing, T>()
    data class Fail<out E : KnownThrowable>(val cause: E) : State<E, Nothing>()
    companion object {
        fun <T> ok(result: T) = Ok(result)
        fun <E : KnownThrowable> fail(e: E) = Fail(e)
    }
}