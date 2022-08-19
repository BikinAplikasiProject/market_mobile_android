package com.iddevops.core.ui.ui.component.inputfield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.iddevops.core.ui.ui.theme.color.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KitInputFieldMultiLine(
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
        modifier = Modifier
            .then(modifier)
    ) {
        TextMicro(
            label,
            color = Gray500
        )
        Spacer(modifier = Modifier.height(dp8))

        Card(
            border = BorderStroke(
                dp1,
                color = getCardBorderColor(
                    errorText.isNotBlank(),
                    isFocus.value
                )
            ),
            modifier = Modifier
                .defaultMinSize(dp100, dp52)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .background(NeutralWhite)
                    .padding(dp16, dp12, dp16, dp12)
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    TextRegularStandard(
                        text = prefix,
                        color = Gray500,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                    if (prefix.isNotBlank()) {
                        Spacer(modifier = Modifier.width(dp4))
                    }
                    Box {
                        BasicTextField(
                            value = value,
                            onValueChange = onTextChange,
                            textStyle = Title3
                                .copy(color = Gray700),
                            singleLine = false,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxSize()
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
            }
        }
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

private fun getCardBorderColor(isError: Boolean, isFocus: Boolean): Color {
    return when {
        isError -> Danger.default
        else -> {
            if (isFocus) NeutralBlack else Gray400
        }
    }
}

@Preview
@Composable
fun PreviewInputField2() {
    Column(
        modifier = Modifier.padding(dp16)
    ) {
        KitInputFieldMultiLine(
            label = "Label",
            value = "",
            hint = "Enter some valuej",
            modifier = Modifier.height(dp120)
        ) {

        }
    }
}