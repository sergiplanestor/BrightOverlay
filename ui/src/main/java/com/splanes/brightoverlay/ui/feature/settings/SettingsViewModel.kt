package com.splanes.brightoverlay.ui.feature.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

@HiltViewModel
class SettingsViewModel @Inject constructor(

) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext = Job() + Dispatchers.Default
}