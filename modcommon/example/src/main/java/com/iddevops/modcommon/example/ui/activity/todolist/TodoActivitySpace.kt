package com.iddevops.modcommon.example.ui.activity.todolist

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.control.provider.example.TodoSpace
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.launcher.createLauncher

class TodoActivitySpace() : TodoSpace {
    override fun getLauncher(): ActivityResultContract<TodoSpace.Payload, NOTHING?> {
        return createLauncher(
            activity = TodoActivity::class.java,
            outputType = NOTHING::class.java
        )
    }
}