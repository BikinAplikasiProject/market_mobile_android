package com.iddevops.modules.uikit.ui.screen.button

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.button.OutlinedStadiumButton
import com.iddevops.core.ui.ui.component.button.OutlinedStadiumButtonSmall
import com.iddevops.core.ui.ui.component.button.StadiumButton
import com.iddevops.core.ui.ui.component.button.StadiumButtonSmall
import com.iddevops.core.ui.ui.component.icon.ClickableIcon
import com.iddevops.core.ui.ui.theme.dp16
import com.iddevops.core.ui.util.ButtonState
import com.iddevops.core.ui.util.ContentThemeWrapper
import com.iddevops.modules.uikit.R

@Composable
fun ButtonsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(dp16)
            .fillMaxSize()
            .then(modifier)
    ) {
        Row {
            StadiumButton(label = "Normal") {

            }
            Spacer(modifier = Modifier.width(dp16))
            OutlinedStadiumButton(label = "Normal") {

            }
        }
        Spacer(modifier = Modifier.height(dp16))
        Row {
            StadiumButton(
                label = "Loading",
                state = ButtonState.LOADING
            ) {

            }
            Spacer(modifier = Modifier.width(dp16))
            OutlinedStadiumButton(
                label = "Loading",
                state = ButtonState.LOADING
            ) {

            }
        }
        Spacer(modifier = Modifier.height(dp16))
        Row {
            StadiumButton(
                label = "Disabled",
                state = ButtonState.DISABLED
            ) {

            }
            Spacer(modifier = Modifier.width(dp16))
            OutlinedStadiumButton(
                label = "Disabled",
                state = ButtonState.DISABLED
            ) {

            }
        }
        Spacer(modifier = Modifier.height(dp16))
        Row {
            StadiumButtonSmall(label = "Normal") {

            }
            Spacer(modifier = Modifier.width(dp16))
            OutlinedStadiumButtonSmall(label = "Normal") {

            }
        }
        Spacer(modifier = Modifier.height(dp16))
        Row {
            StadiumButtonSmall(
                label = "Loading",
                state = ButtonState.LOADING
            ) {

            }
            Spacer(modifier = Modifier.width(dp16))
            OutlinedStadiumButtonSmall(
                label = "Loading",
                state = ButtonState.LOADING
            ) {

            }
        }
        Spacer(modifier = Modifier.height(dp16))
        Row {
            StadiumButtonSmall(
                label = "Disabled",
                state = ButtonState.DISABLED
            ) {

            }
            Spacer(modifier = Modifier.width(dp16))
            OutlinedStadiumButtonSmall(
                label = "Disabled",
                state = ButtonState.DISABLED
            ) {

            }
        }
        Spacer(modifier = Modifier.height(dp16))
        ClickableIcon(
            painter = painterResource(
                id = R.drawable.ic_arrow_left_1
            ),
            contentDecryption = stringResource(
                id = R.string.desc_button_navigate_back
            )
        ) {

        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Preview() {
    Box(modifier = Modifier.padding(dp16)) {
        ContentThemeWrapper {
            ButtonsScreen()
        }
    }
}