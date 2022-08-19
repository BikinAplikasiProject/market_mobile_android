package com.iddevops.modcommon.example.ui.activity.todolist

import androidx.compose.runtime.Composable
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.activity.ActivityResultEmitter
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.core.main.util.handler.BackPressHandler
import com.iddevops.core.main.util.handler.BackPressHandlerProvider
import com.iddevops.modcommon.example.ui.screen.todolist.TodoScreen

class TodoActivity : BaseActivity(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable { TodoScreen() }

    override fun onEarlyCreate() {
        super.onEarlyCreate()
        BackPressHandlerProvider.add(lifecycle, backPressHandler)
    }

    private val backPressHandler by lazy {
        object : BackPressHandler {
            override fun onBackPress() {
                activityReturnOK(NOTHING("from home: alksndmandlanldnandlad"))
            }

            override fun isActive(): Boolean {
                return true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        BackPressHandlerProvider.remove(backPressHandler)
    }
}