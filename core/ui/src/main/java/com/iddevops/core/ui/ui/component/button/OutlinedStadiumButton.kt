package com.iddevops.core.ui.ui.component.button

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.text.TextButton
import com.iddevops.core.ui.ui.theme.*
import com.iddevops.core.ui.ui.theme.color.Gray400
import com.iddevops.core.ui.ui.theme.color.NeutralWhite
import com.iddevops.core.ui.util.ButtonState
import com.iddevops.core.ui.util.stadiumButtonBorderColor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun OutlinedStadiumButton(
    modifier: Modifier = Modifier,
    label: String,
    state: ButtonState = ButtonState.NORMAL,
    onClick: () -> Unit
) {

    val clicked = remember { mutableStateOf(false) }

    val hasFocus = remember { mutableStateOf(false) }

    val animatedScale = animateFloatAsState(targetValue = if (clicked.value) .9f else 1f)

    Card(
        border = BorderStroke(
            dp2,
            stadiumButtonBorderColor(
                state = state,
                hasFocus = hasFocus.value
            )
        ),
        shape = rounded8,
        modifier = Modifier
            .scale(animatedScale.value)
            .then(modifier)
    ) {
        Box(
            modifier = Modifier
                .defaultMinSize(dp156, dp48)
                .focusable(true)
                .onFocusEvent {
                    hasFocus.value = it.hasFocus
                }
                .background(NeutralWhite)
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
        ) {

            Box(
                modifier = Modifier
                    .padding(dp16, dp8, dp16, dp8)
                    .align(Alignment.Center)
            ) {
                when (state) {
                    ButtonState.LOADING -> CircularProgressIndicator(
                        modifier = Modifier
                            .height(dp20)
                            .width(dp20)
                            .align(Alignment.Center),
                        color = stadiumButtonBorderColor(false, ButtonState.NORMAL),
                        strokeWidth = dp2
                    )
                    else -> TextButton(
                        text = label,
                        color = when (state) {
                            ButtonState.DISABLED -> Gray400
                            else -> stadiumButtonBorderColor(
                                state = state,
                                hasFocus = hasFocus.value
                            )
                        },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun StadiumStadiumButtonPreview() {
    ContentThemeWrapper {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(dp16)
        ) {
            OutlinedStadiumButton(
                label = "Outlined Stadium Button Normal"
            ) {

            }
            Spacer(modifier = Modifier.height(dp8))
            OutlinedStadiumButton(
                label = "Outlined Stadium Button Loading",
                state = ButtonState.LOADING
            ) {

            }
            Spacer(modifier = Modifier.height(dp8))
            OutlinedStadiumButton(
                label = "Outlined Stadium Button Disabled",
                state = ButtonState.DISABLED
            ) {

            }
        }
    }
}