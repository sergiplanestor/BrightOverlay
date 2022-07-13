package com.splanes.commons.ui.component.toast

/*
 * Created on 11/07/2022 at 1:42
 * @author Sergi Planes
 * @since 1.0.0
 */
 
data class ToastModel(
    val message: String,
    val duration: Int,
    val shown: Boolean = false
)