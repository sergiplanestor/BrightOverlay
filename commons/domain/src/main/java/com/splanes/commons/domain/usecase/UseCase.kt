package com.splanes.commons.domain.usecase

import android.os.Parcelable
import com.splanes.commons.domain.errors.handler.AppThrowableHandler
import com.splanes.commons.domain.errors.model.KnownThrowable
import com.splanes.commons.domain.model.State
import javax.inject.Inject

abstract class UseCase<Params : UseCase.Request, Result> {

    @Inject
    private lateinit var errorHandler: AppThrowableHandler

    suspend operator fun invoke(params: Params): State<KnownThrowable, Result> =
        try {
            execute(params).let { result -> State.ok(result) }
        } catch (e: Throwable) {
            if (e.isSilenced()) {
                onThrowableSilenced(e)
            } else {
                e.handle()
            }
        }

    @Throws
    abstract suspend fun execute(params: Params): Result

    protected open fun Throwable.isSilenced(): Boolean = false

    protected open fun onThrowableSilenced(throwable: Throwable): State.Ok<Result> =
        throw NotImplementedError(ERR_MSG_SILENCED)

    protected open fun Throwable.handle(): State.Fail<KnownThrowable> =
        errorHandler.handleOrNull(throwable = this)?.let { e -> State.fail(e) } ?: throw this

    interface Request : Parcelable
}

private const val ERR_MSG_SILENCED =
    "Silenced throwable thrown but `onThrowableSilenced()` method has not been impl. " +
            "When silencing an error, this method must be overridden on child."