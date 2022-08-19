package com.iddevops.core.main.util.toast

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.iddevops.core.main.domain.payload.Toast


@Composable
fun MakeToast(payload: Toast) = android.widget.Toast.makeText(
    LocalContext.current.applicationContext,
    payload.message,
    if (payload.longToast)
        android.widget.Toast.LENGTH_LONG
    else android.widget.Toast.LENGTH_SHORT
).show()