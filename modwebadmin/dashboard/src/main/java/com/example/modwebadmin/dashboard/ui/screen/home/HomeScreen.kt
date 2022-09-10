package com.example.modwebadmin.dashboard.ui.screen.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.theme.ContentThemeWrapper

@Composable
fun HomeScreen() {
    Row {
        FragmentOne(modifier = Modifier.fillMaxHeight().weight(1f))
        FragmentTwo()
    }
}

@Preview(showSystemUi = true, device = Devices.NEXUS_10)
@Composable
fun Preview() {
    ContentThemeWrapper {
        HomeScreen()
    }
}