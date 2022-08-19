package com.iddevops.modcommon.example.ui.screen.pushnotification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.pushnotif.PushNotification
import com.iddevops.core.ui.ui.component.pushnotif.PushNotificationPreview
import com.iddevops.core.ui.ui.theme.dp16
import com.iddevops.core.ui.util.PushNotificationType

@Composable
fun PushNotificationScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Spacer(modifier = Modifier.weight(1f))
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

@Preview
@Composable
fun PushNotificationScreenPreview() {
    PushNotificationPreview()
}