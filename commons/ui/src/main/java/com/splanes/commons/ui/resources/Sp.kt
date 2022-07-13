package com.splanes.commons.ui.resources

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/*
 * Created on 13/07/2022 at 2:13
 * @author Sergi Planes
 * @since 1.0.0
 */
 
operator fun TextUnit.plus(other: TextUnit): TextUnit =
    (this.value + other.value).sp

operator fun TextUnit.plus(value: Double): TextUnit = (this + value.sp)

operator fun TextUnit.minus(other: TextUnit): TextUnit =
    (this.value - other.value).sp

operator fun TextUnit.minus(value: Double): TextUnit = (this - value.sp)