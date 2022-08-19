package com.iddevops.core.ui.ui.component.inputfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.ui.ui.component.text.TextMicro
import com.iddevops.core.ui.ui.component.text.TextRegularStandard
import com.iddevops.core.ui.ui.component.text.TextSuperSmallStandard
import com.iddevops.core.ui.ui.component.text.TextTitle3
import com.iddevops.core.ui.ui.theme.*
import com.iddevops.core.ui.ui.theme.color.Danger
import com.iddevops.core.ui.ui.theme.color.Gray400
import com.iddevops.core.ui.ui.theme.color.Gray500
import com.iddevops.core.ui.ui.theme.color.Gray700

@Composable
fun KitInputField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    hint: String = "",
    prefix: String = "",
    helperText: String = "",
    errorText: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onTextChange: (String) -> Unit
) {
    val isFocus = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        TextMicro(
            label,
            color = Gray500
        )
        Spacer(modifier = Modifier.height(dp8))
        Row {
            TextRegularStandard(
                text = prefix,
                color = Gray500,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            if (prefix.isNotBlank()) {
                Spacer(modifier = Modifier.width(dp4))
            }
            Box(
                modifier = Modifier.height(dp32)
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onTextChange,
                    textStyle = Title3
                        .copy(color = Gray700),
                    singleLine = true,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .onFocusChanged {
                            isFocus.value = it.hasFocus
                        },
                    visualTransformation = visualTransformation,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions
                )
                if (value.isBlank()) {
                    TextTitle3(
                        text = hint,
                        color = Gray500
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(dp8))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dp1)
                .background(
                    getUnderLineColor(errorText.isNotBlank(), isFocus.value)
                )
        )
        if (helperText.isNotBlank()) {
            Spacer(modifier = Modifier.height(dp8))
            TextSuperSmallStandard(
                text = helperText,
                color = Gray500
            )
        }
        if (errorText.isNotBlank()) {
            Spacer(modifier = Modifier.height(dp8))
            TextSuperSmallStandard(
                text = errorText,
                color = Danger.default
            )
        }
    }
}

private fun getUnderLineColor(isError: Boolean, isFocus: Boolean): Color {
    return when {
        isError -> Danger.default
        else -> {
            if (isFocus) Gray700
            else Gray400
        }
    }
}

@Preview
@Composable
fun PreviewInputField() {
    Column(
        modifier = Modifier.padding(dp16)
    ) {
        KitInputField(
            label = "Label",
            value = "",
            hint = "Enter some value"
        ) {

        }
    }
}