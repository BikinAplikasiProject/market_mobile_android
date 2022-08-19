package com.iddevops.modules.uikit.ui.screen.input

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.inputfield.KitInputField
import com.iddevops.core.ui.ui.component.inputfield.KitInputFieldMultiLine
import com.iddevops.core.ui.ui.component.text.TextLarge
import com.iddevops.core.ui.ui.theme.dp16
import com.iddevops.core.ui.ui.theme.dp200
import com.iddevops.core.ui.ui.theme.dp32
import com.iddevops.core.ui.ui.theme.dp4

@Composable
fun InputsScreen(modifier: Modifier = Modifier) {

    val text = remember { mutableStateOf("") }
    val error = remember { mutableStateOf("") }
    val helper = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(dp16)
            .fillMaxSize()
            .then(modifier)
    ) {

        TextLarge(text = "Type error to emulate error")
        Spacer(modifier = Modifier.height(dp4))
        TextLarge(text = "Type helper to emulate helper")
        Spacer(modifier = Modifier.height(dp32))

        KitInputField(
            label = "Label",
            value = text.value,
            hint = "Enter some value",
            helperText = helper.value,
            errorText = error.value
        ) {
            text.value = it

            when {
                it.contains("error") -> {
                    error.value = it
                }
                it.contains("helper") -> {
                    helper.value = it
                }
                else -> {
                    if (error.value.isNotBlank())
                        error.value = ""
                    if (helper.value.isNotBlank())
                        helper.value = ""
                }
            }
        }
        Spacer(modifier = Modifier.height(dp16))
        KitInputFieldMultiLine(
            label = "Label",
            value = text.value,
            hint = "Enter some value",
            helperText = helper.value,
            errorText = error.value,
            modifier = Modifier.height(dp200)
        ) {
            text.value = it

            when {
                it.contains("error") -> {
                    error.value = it
                }
                it.contains("helper") -> {
                    helper.value = it
                }
                else -> {
                    if (error.value.isNotBlank())
                        error.value = ""
                    if (helper.value.isNotBlank())
                        helper.value = ""
                }
            }
        }
    }
}

@Preview
@Composable
fun InputScreenPreview() {
    Column(
        modifier = Modifier.padding(dp16)
    ) {
        InputsScreen()
    }
}
