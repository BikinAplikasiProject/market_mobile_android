package com.iddevops.modbuyer.dashboard.ui.activity.store

import androidx.compose.runtime.Composable
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.activity.ActivityResultEmitter
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.core.main.util.handler.BackPressHandler
import com.iddevops.core.main.util.handler.BackPressHandlerProvider
import com.iddevops.modbuyer.dashboard.ui.component.codescanner.CodeScanner

class StoreActivity : BaseActivity(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable {
        CodeScanner()
    }

    override fun onEarlyCreate() {
        super.onEarlyCreate()
        BackPressHandlerProvider.add(lifecycle, backPressHandler)
    }

    private val backPressHandler by lazy {
        object : BackPressHandler {
            override fun onBackPress() {
                activityReturnCancel()
            }

            override fun isActive(): Boolean {
                return true
            }

        }
    }
}