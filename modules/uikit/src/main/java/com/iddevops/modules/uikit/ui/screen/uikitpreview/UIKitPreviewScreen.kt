package com.iddevops.modules.uikit.ui.screen.uikitpreview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.*
import com.iddevops.core.ui.ui.component.text.TextButton
import com.iddevops.core.ui.ui.theme.color.NeutralBlack
import com.iddevops.core.ui.ui.theme.color.NeutralWhite
import com.iddevops.core.ui.ui.theme.color.PrimaryGreen
import com.iddevops.core.ui.util.ContentThemeWrapper
import com.iddevops.modules.uikit.ui.screen.button.ButtonsScreen
import com.iddevops.modules.uikit.ui.screen.color.ColorScreen
import com.iddevops.modules.uikit.ui.screen.input.InputsScreen
import com.iddevops.modules.uikit.ui.screen.pushnotification.PushNotificationScreen
import com.iddevops.modules.uikit.ui.screen.typography.TypographyScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun UIKitPreviewScreen() {
    ContentThemeWrapper(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState()

        val tabs = listOf(
            TabItem.Typography,
            TabItem.Colors,
            TabItem.Buttons,
            TabItem.Inputs,
            TabItem.Notification
        )

        Column {
            TabsContent(tabs = tabs, pagerState)
            Tabs(tabs = tabs, pagerState = pagerState)
        }
    }

}

sealed class TabItem(var title: String, var screen: @Composable () -> Unit) {
    object Typography : TabItem("Typography", { TypographyScreen() })
    object Colors : TabItem("Color", { ColorScreen() })
    object Buttons : TabItem("Buttons", { ButtonsScreen() })
    object Inputs : TabItem("Inputs", { InputsScreen() })
    object Notification : TabItem("Notification", { PushNotificationScreen() })
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = NeutralBlack,
        backgroundColor = PrimaryGreen,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                color = NeutralWhite
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { TextButton(text = tab.title, color = NeutralWhite) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun ColumnScope.TabsContent(tabs: List<TabItem>, pageState: PagerState) {
    HorizontalPager(
        count = tabs.size,
        state = pageState,
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
    ) { page ->
        tabs[page].screen.invoke()
    }
}
