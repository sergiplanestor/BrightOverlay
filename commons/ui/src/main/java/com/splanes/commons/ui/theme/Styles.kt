package com.splanes.commons.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeTypographies
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Body
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Display
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Headline
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Label
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Title
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Typographies
import com.splanes.toolkit.compose.ui.theme.utils.size.UiSize

/*
 * Created on 10/07/2022 at 3:39
 * @author Sergi Planes
 * @since 1.0.0
 */

@Composable
fun textStyle(size: Double? = null, block: @Composable ThemeTypographies.() -> TextStyle): TextStyle =
    Typographies.block().let { if (size != null) it.copy(fontSize = size.sp) else it }

@Composable
fun textStyleDefault(
    size: Double? = null,
    block: @Composable ThemeTypographies.() -> UiSize<TextStyle>
): @Composable UiSize<TextStyle>.() -> TextStyle =
    @Composable { textStyle(size) { block().medium } }

@Composable
fun displayStyle(size: Double? = null, block: @Composable UiSize<TextStyle>.() -> TextStyle = textStyleDefault(size) { Display }): TextStyle =
    Typographies.Display.block().let { if (size != null) it.copy(fontSize = size.sp) else it }

@Composable
fun headlineStyle(size: Double? = null, block: @Composable UiSize<TextStyle>.() -> TextStyle = textStyleDefault(size) { Headline }): TextStyle =
    Typographies.Headline.block().let { if (size != null) it.copy(fontSize = size.sp) else it }

@Composable
fun titleStyle(size: Double? = null, block: @Composable UiSize<TextStyle>.() -> TextStyle = textStyleDefault(size) { Title }): TextStyle =
    Typographies.Title.block().let { if (size != null) it.copy(fontSize = size.sp) else it }

@Composable
fun bodyStyle(size: Double? = null, block: @Composable UiSize<TextStyle>.() -> TextStyle = textStyleDefault(size) { Body }): TextStyle =
    Typographies.Body.block().let { if (size != null) it.copy(fontSize = size.sp) else it }

@Composable
fun labelStyle(size: Double? = null, block: @Composable UiSize<TextStyle>.() -> TextStyle = textStyleDefault(size) { Label }): TextStyle =
    Typographies.Label.block().let { if (size != null) it.copy(fontSize = size.sp) else it }