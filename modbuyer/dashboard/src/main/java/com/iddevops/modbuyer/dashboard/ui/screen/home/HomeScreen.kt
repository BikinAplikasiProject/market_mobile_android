package com.iddevops.modbuyer.dashboard.ui.screen.home

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.iddevops.core.main.util.handler.BackPressHandler
import com.iddevops.core.main.util.handler.BackPressHandlerProvider
import com.iddevops.core.ui.ui.component.text.TextRegularEmphasize

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val livecycle = LocalLifecycleOwner.current

    val backPressHandlerIsActive = remember {
        mutableStateOf(true)
    }
    val backPressHandler = remember {
        object : BackPressHandler {
            override fun onBackPress() {
                Toast.makeText(context, "aldkalda", Toast.LENGTH_SHORT).show()
                backPressHandlerIsActive.value = false
            }

            override fun isActive(): Boolean {
                return backPressHandlerIsActive.value
            }
        }
    }

    DisposableEffect(key1 = Unit) {
        BackPressHandlerProvider.add(livecycle.lifecycle, backPressHandler)

        onDispose {
            BackPressHandlerProvider.remove(backPressHandler)
        }
    }

    TextRegularEmphasize(text = "Home")
}