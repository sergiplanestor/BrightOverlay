package com.splanes.commons.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.splanes.commons.domain.errors.model.KnownThrowable
import com.splanes.commons.ui.component.toast.ToastModel
import com.splanes.commons.domain.model.State
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
 * Created on 11/07/2022 at 1:11
 * @author Sergi Planes
 * @since 1.0.0
 */
 
abstract class BaseViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + Job()

    private val toastChannel: Channel<ToastModel> = Channel()
    val toastStateFlow: Flow<ToastModel> = toastChannel.receiveAsFlow()

    open fun toast(message: String, duration: Int = Toast.LENGTH_LONG) {
        val model = ToastModel(message = message, duration = duration)
        toastChannel.trySend(model)
            .takeIf { r -> !r.isSuccess }
            ?.run { launch { toastChannel.send(model) } }
    }

    suspend fun <E : KnownThrowable, T> State<E, T>.handleOnUi(action: State<E, T>.() -> Unit = {}) =
        onUi { action() }
}

fun ViewModel.launch(
    context: CoroutineContext = Dispatchers.Default,
    block: suspend CoroutineScope.() -> Unit
): Job =
    viewModelScope.launch(context) { block() }

suspend fun <T> onUi(block: suspend CoroutineScope.() -> T): T =
    withContext(Dispatchers.Main) { block() }