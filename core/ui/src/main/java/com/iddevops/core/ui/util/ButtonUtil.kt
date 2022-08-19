package com.iddevops.core.ui.util

import androidx.compose.ui.graphics.Color
import com.iddevops.core.ui.ui.theme.color.*


fun stadiumButtonBackground(
    hasFocus: Boolean,
    state: ButtonState
): Color {
    return when {
        state == ButtonState.LOADING -> ButtonLoading
        state == ButtonState.DISABLED -> ButtonDisabled
        hasFocus && state == ButtonState.NORMAL -> ButtonHovered
        else -> ButtonNormal
    }
}

fun stadiumButtonBorderColor(
    hasFocus: Boolean,
    state: ButtonState
): Color {
    return when {
        state == ButtonState.LOADING -> ButtonLoading
        state == ButtonState.DISABLED -> Gray300
        hasFocus && state == ButtonState.NORMAL -> ButtonHovered
        else -> ButtonNormal
    }
}