package com.iddevops.core.main.util.launcher

import android.content.Context
import android.content.Intent
import com.iddevops.core.main.util.gson.JsonConvertAble

fun <P : JsonConvertAble, O> createLauncher(
    activity: Class<*>,
    outputType: Class<O>
): BaseLauncher<P, O> {
    return object : BaseLauncher<P, O>() {
        override val intent: (c: Context) -> Intent
            get() = { c -> Intent(c, activity) }
        override val outputType: Class<O>
            get() = outputType
    }
}