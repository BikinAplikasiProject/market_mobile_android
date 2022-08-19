package com.iddevops.basecompose.ui.screen.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(name: String) {
    Text(text = "Hello $name!")
}