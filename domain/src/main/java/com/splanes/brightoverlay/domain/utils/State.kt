package com.splanes.brightoverlay.domain.utils

import com.splanes.brightoverlay.domain.commons.errors.model.KnownThrowable

sealed class State<out E : KnownThrowable, out T> {
    data class Ok<out T>(val result: T) : State<Nothing, T>()
    data class Fail<out E : KnownThrowable>(val cause: E) : State<E, Nothing>()
    companion object {
        fun <T> ok(result: T) = Ok(result)
        fun <E : KnownThrowable> fail(e: E) = Fail(e)
    }
}

/*

sealed class State<out E : Throwable, out T> {
    data class Ok<out E : Throwable, out T>(val result: T) : State<E, T>()
    data class Fail<out E : Throwable, out T>(val cause: E) : State<E, T>()
    companion object {
        fun <E : Throwable, T> ok(result: T) = Ok<E, T>(result)
        fun <E : Throwable, T> fail(e: E) = Fail<E, T>(e)
    }
}

* */