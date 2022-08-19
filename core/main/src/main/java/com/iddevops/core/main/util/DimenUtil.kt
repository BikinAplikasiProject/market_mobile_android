package com.iddevops.core.main.util

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object DimenUtil {
    var scale = 1f
    var screenWidth = 1280.dp
    var screenHeight = 760.dp
}

// TODO: run this function in app init
fun setupScreenSize(widthDp: Dp, heightDp: Dp) {
    // save data
    DimenUtil.screenWidth = widthDp
    DimenUtil.screenHeight = heightDp

    val widthScale = widthDp / 1280.0.dp
    val heightScale = heightDp / 760.0.dp

    // prefer bigger
    DimenUtil.scale = if (widthScale > heightScale) {
        widthScale
    } else {
        heightScale
    }
}

val Int.toDp: Dp
    get() = this.dp * DimenUtil.scale

val Int.toSp: TextUnit
    get() = this.sp * DimenUtil.scale