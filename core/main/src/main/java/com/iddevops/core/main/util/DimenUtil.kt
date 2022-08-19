package com.iddevops.core.main.util

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Deprecated("only tablets are supported")
object DimenUtil {
    var scale = 1f
    var screenWidth = 1280.dp
    var screenHeight = 760.dp
    var isTablet = true
}

@Deprecated("only tablets are supported")
fun setupScreenSize(widthDp: Dp, heightDp: Dp, isTablet: Boolean = true) {
    // save data
    val isPortrait = widthDp < heightDp
    val widthScale = widthDp / if (isPortrait) 760.0.dp else 1280.0.dp
    val heightScale = heightDp / if (isPortrait) 1280.0.dp else 760.0.dp

    with(DimenUtil) {
        screenWidth = widthDp
        screenHeight = heightDp
        scale = if (widthScale > heightScale) {
            widthScale
        } else {
            heightScale
        }
        this.isTablet = false
    }
    // prefer bigger
}

val Int.toDp: Dp
    get() = if (DimenUtil.isTablet) this.dp * DimenUtil.scale else this.dp

val Int.toSp: TextUnit
    get() = if (DimenUtil.isTablet) this.sp * DimenUtil.scale else this.sp