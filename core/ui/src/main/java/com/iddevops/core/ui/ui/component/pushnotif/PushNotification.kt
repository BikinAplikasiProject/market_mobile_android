package com.iddevops.core.ui.ui.component.pushnotif

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.R
import com.iddevops.core.ui.ui.component.text.TextRegularStandard
import com.iddevops.core.ui.ui.theme.color.*
import com.iddevops.core.ui.ui.theme.dp0
import com.iddevops.core.ui.ui.theme.dp10
import com.iddevops.core.ui.ui.theme.dp16
import com.iddevops.core.ui.ui.theme.dp64
import com.iddevops.core.ui.util.PushNotificationType

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PushNotification(
    text: String,
    type: PushNotificationType,
    onClick: () -> Unit
) {
    val isClicked = remember { mutableStateOf(false) }
    val scale = animateFloatAsState(targetValue = if (isClicked.value) .9f else 1f)

    Box(
        modifier = Modifier
            .scale(scale.value)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_UP -> {
                        isClicked.value = false
                        onClick.invoke()
                    }

                    MotionEvent.ACTION_DOWN -> {
                        isClicked.value = true
                    }
                }

                true
            }
    ) {
        Box(
            modifier = Modifier
                .background(
                    when (type) {
                        PushNotificationType.INFO -> Info.default
                        PushNotificationType.POSITIVE -> Positive.default
                        PushNotificationType.WARNING -> Warning.default
                        PushNotificationType.DANGER -> Danger.default
                    }
                )
        ) {
            Row(
                modifier = Modifier
                    .height(dp64)
                    .fillMaxWidth()
                    .padding(dp16, dp0, dp16, dp0)
            ) {
                Image(
                    painter = painterResource(
                        id = when (type) {
                            PushNotificationType.INFO -> R.drawable.ic_icon___filled___info_circle
                            PushNotificationType.DANGER -> R.drawable.ic_icon___filled___cross_circle
                            PushNotificationType.POSITIVE -> R.drawable.ic_icon___filled___checkmark_circle
                            PushNotificationType.WARNING -> R.drawable.ic_icon___filled___warning_filled
                        }
                    ),
                    contentDescription = "Notification Icon",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(dp10))
                TextRegularStandard(
                    text = text, color = NeutralWhite,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Preview
@Composable
fun PushNotificationPreview() {

    Column {
        PushNotification(
            text = "Danger",
            type = PushNotificationType.DANGER
        ) {

        }
        Spacer(modifier = Modifier.height(dp16))
        PushNotification(
            text = "Info",
            type = PushNotificationType.INFO
        ) {

        }
        Spacer(modifier = Modifier.height(dp16))
        PushNotification(
            text = "Positive",
            type = PushNotificationType.POSITIVE
        ) {

        }
        Spacer(modifier = Modifier.height(dp16))
        PushNotification(
            text = "Warning",
            type = PushNotificationType.WARNING
        ) {

        }
    }
}