package com.iddevops.modcommon.example.ui.screen.typography

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.text.*
import com.iddevops.core.ui.ui.theme.ContentThemeWrapper
import com.iddevops.core.ui.ui.theme.dp16

@Composable
fun TypographyScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .padding(dp16)
            .fillMaxSize()
            .then(modifier)
    ) {
        Column(
            modifier = Modifier.scrollable(
                state = ScrollableState { it },
                orientation = Orientation.Vertical
            )
        ) {
            TextTitle1(text = "TextTitle1")
            TextTitle2(text = "TextTitle2")
            TextTitle3(text = "TextTitle3")
            Spacer(modifier = Modifier.height(dp16))
            TextSubtitle(text = "TextSubtitle")
            Spacer(modifier = Modifier.height(dp16))
            TextLarge(text = "TextLarge")
            Spacer(modifier = Modifier.height(dp16))
            TextRegularStandard(text = "TextRegularStandard")
            TextRegularStrikeThrough(text = "TextRegularStrikeThrough")
            TextRegularEmphasize(text = "TextRegularEmphasize")
            Spacer(modifier = Modifier.height(dp16))
            TextSmallStandard(text = "TextSmallStandard")
            TextSmallStrikeThrough(text = "TextSmallStrikeThrough")
            TextSmallEmphasize(text = "TextSmallEmphasize")
            Spacer(modifier = Modifier.height(dp16))
            TextSuperSmallStandard(text = "TextSuperSmallStandard")
            TextSuperSmallStrikeThrough(text = "TextSuperSmallStrikeThrough")
            TextSuperSmallEmphasize(text = "TextSuperSmallEmphasize")
            Spacer(modifier = Modifier.height(dp16))
            TextMicro(text = "TextMicro")
            Spacer(modifier = Modifier.height(dp16))
            TextButton(text = "TextButton")
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    ContentThemeWrapper {
        TypographyScreen()
    }
}