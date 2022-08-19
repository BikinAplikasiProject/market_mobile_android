package com.iddevops.core.ui.ui.component.icon

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.theme.dp24

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ClickableIcon(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDecryption: String,
    onClick: () -> Unit
) {
    val clicked = remember { mutableStateOf(false) }
    val animatedScale = animateFloatAsState(targetValue = if (clicked.value) .9f else 1f)

    Image(
        painter = painter,
        contentDescription = contentDecryption,
        modifier = Modifier
            .scale(animatedScale.value)
            .height(dp24)
            .width(dp24)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        clicked.value = true
                    }

                    MotionEvent.ACTION_UP -> {
                        clicked.value = false
                        onClick.invoke()
                    }
                }
                true
            }
            .then(modifier)
    )
}

@Preview
@Composable
fun ClickableIconPreview() {

}