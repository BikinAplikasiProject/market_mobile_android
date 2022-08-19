package com.iddevops.core.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iddevops.core.ui.ui.theme.BaseComposeTheme

@Composable
fun ContentThemeWrapper(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    BaseComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background,
            content = content
        )
    }
}