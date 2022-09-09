package com.iddevops.core.ui.ui.component.button

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.text.TextButton
import com.iddevops.core.ui.ui.theme.*
import com.iddevops.core.ui.ui.theme.color.Gray500
import com.iddevops.core.ui.ui.theme.color.NeutralWhite
import com.iddevops.core.ui.util.ButtonState
import com.iddevops.core.ui.util.stadiumButtonBackground

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun StadiumButtonSmall(
    modifier: Modifier = Modifier,
    label: String,
    state: ButtonState = ButtonState.NORMAL,
    onClick: () -> Unit
) {

    val clicked = remember { mutableStateOf(false) }

    val hasFocus = remember { mutableStateOf(false) }

    val animatedScale = animateFloatAsState(targetValue = if (clicked.value) .9f else 1f)

    Box(
        modifier = Modifier
            .scale(animatedScale.value)
    ) {
        Box(
            modifier = Modifier
                .clip(rounded8)
                .background(
                    color = when (val isFocus = hasFocus.value) {
                        else -> stadiumButtonBackground(
                            hasFocus = isFocus,
                            state = state
                        )
                    }
                )
                .padding(dp8, dp0, dp8, dp0)
                .align(Alignment.Center)
                .height(dp28)
                .defaultMinSize(dp88, dp28)
                .focusable(true)
                .onFocusEvent {
                    hasFocus.value = it.hasFocus
                }
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            clicked.value = true
                        }

                        MotionEvent.ACTION_UP -> {
                            clicked.value = false
                            if (state != ButtonState.DISABLED)
                                onClick.invoke()
                        }
                    }
                    true
                }
                .then(modifier)
        ) {
            when (state) {
                ButtonState.LOADING -> CircularProgressIndicator(
                    modifier = Modifier
                        .height(dp20)
                        .width(dp20)
                        .align(Alignment.Center),
                    color = NeutralWhite,
                    strokeWidth = dp2
                )

                else -> TextButton(
                    text = label,
                    color = when (state) {
                        ButtonState.DISABLED -> Gray500
                        else -> NeutralWhite
                    },
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StadiumButtonSmallPreview() {
    ContentThemeWrapper {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(dp16)
        ) {
            StadiumButtonSmall(
                label = "Stadium Button Normal"
            ) {

            }
            Spacer(modifier = Modifier.height(dp8))
            StadiumButtonSmall(
                label = "Stadium Button Loading",
                state = ButtonState.LOADING
            ) {

            }
            Spacer(modifier = Modifier.height(dp8))
            StadiumButtonSmall(
                label = "Stadium Button Disabled",
                state = ButtonState.DISABLED
            ) {

            }
        }
    }
}