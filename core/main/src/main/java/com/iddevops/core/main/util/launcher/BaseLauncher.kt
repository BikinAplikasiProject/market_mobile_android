package com.iddevops.core.main.util.launcher

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.core.main.util.activity.ActivityResultEmitter
import com.iddevops.core.main.util.gson.JsonConvertAble
import com.iddevops.core.main.util.gson.toObject

abstract class BaseLauncher<P : JsonConvertAble, O>
    : ActivityResultContract<P, O>() {

    abstract val intent: (c: Context) -> Intent
    abstract val outputType: Class<O>

    override fun createIntent(context: Context, input: P): Intent {
        return with(intent.invoke(context)) {
            putExtra(ActivityResultEmitter.KEY.PAYLOAD.name, input.toStringJSON())
            this
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): O {
        return intent?.getStringExtra(ActivityResultEmitter.KEY.RESULT.name)?.toObject(outputType)
            ?: run {
                // TODO: firebase crashlytic here
                throw NullPointerException()
            }
    }
}