package com.iddevops.modcommon.example.ui.screen.color

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.text.TextTitle2
import com.iddevops.core.ui.ui.theme.*
import com.iddevops.core.ui.ui.theme.color.*

@Composable
fun ColorScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .padding(dp16, dp0, dp16, dp0)
            .fillMaxSize()
            .then(modifier)
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(dp16))
            ColorBox(name = "PrimaryGreen", color = PrimaryGreen)
            ColorBox(name = "PrimaryMagenta", color = PrimaryMagenta)
            ColorBox(name = "PrimaryYellow", color = PrimaryYellow)
            ColorBox(name = "PrimaryCream", color = PrimaryCream)
            ColorBox(name = "PrimaryGray", color = PrimaryGray)

            Spacer(modifier = Modifier.height(dp32))

            ColorBox(name = "Gray100", color = Gray100)
            ColorBox(name = "Gray200", color = Gray200)
            ColorBox(name = "Gray300", color = Gray300)
            ColorBox(name = "Gray400", color = Gray400)
            ColorBox(name = "Gray500", color = Gray500)
            ColorBox(name = "Gray600", color = Gray600)
            ColorBox(name = "Gray700", color = Gray700)

            Spacer(modifier = Modifier.height(dp32))

            ColorBox(name = "NeutralBlack", color = NeutralBlack)
            ColorBox(name = "NeutralWhite", color = NeutralWhite)

            Spacer(modifier = Modifier.height(dp32))

            ColorBox(name = "Info.darker", color = Info.darker)
            ColorBox(name = "Info.dark", color = Info.dark)

            ColorBox(name = "Info.default", color = Info.default)

            ColorBox(name = "Info.light", color = Info.light)
            ColorBox(name = "Info.lighter", color = Info.lighter)

            Spacer(modifier = Modifier.height(dp32))

            ColorBox(name = "Positive.darker", color = Positive.darker)
            ColorBox(name = "Positive.dark", color = Positive.dark)
            ColorBox(name = "Positive.default", color = Positive.default)
            ColorBox(name = "Positive.light", color = Positive.light)
            ColorBox(name = "Positive.lighter", color = Positive.lighter)

            Spacer(modifier = Modifier.height(dp32))

            ColorBox(name = "Warning.darker", color = Warning.darker)
            ColorBox(name = "Warning.dark", color = Warning.dark)
            ColorBox(name = "Warning.default", color = Warning.default)
            ColorBox(name = "Warning.light", color = Warning.light)
            ColorBox(name = "Warning.lighter", color = Warning.lighter)

            Spacer(modifier = Modifier.height(dp32))

            ColorBox(name = "Danger.darker", color = Danger.darker)
            ColorBox(name = "Danger.dark", color = Danger.dark)
            ColorBox(name = "Danger.default", color = Danger.default)
            ColorBox(name = "Danger.light", color = Danger.light)
            ColorBox(name = "Danger.lighter", color = Danger.lighter)

            Spacer(modifier = Modifier.height(dp16))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorBox(
    name: String,
    color: Color
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(dp1, Gray400)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color)
            ) {
                TextTitle2(
                    text = name,
                    color = NeutralWhite,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dp8)
                )
            }
        }

        Spacer(modifier = Modifier.height(dp8))

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    ContentThemeWrapper {
        ColorScreen()
    }
}