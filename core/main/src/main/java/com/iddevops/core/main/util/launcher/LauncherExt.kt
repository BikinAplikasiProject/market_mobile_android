package com.iddevops.core.main.util.launcher

import android.content.Context
import android.content.Intent
import com.iddevops.core.main.util.gson.JsonConvertAble

fun <P : JsonConvertAble, O> createLauncher(
    intent: (c: Context) -> Intent,
    outputType: Class<O>
): BaseLauncher<P, O> {
    return object : BaseLauncher<P, O>() {
        override val intent: (c: Context) -> Intent
            get() = intent
        override val outputType: Class<O>
            get() = outputType
    }
}