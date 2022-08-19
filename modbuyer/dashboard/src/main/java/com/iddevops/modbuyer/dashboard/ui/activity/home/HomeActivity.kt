package com.iddevops.modbuyer.dashboard.ui.activity.home

import androidx.compose.runtime.Composable
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.activity.ActivityResultEmitter
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.core.main.util.handler.BackPressHandler
import com.iddevops.core.main.util.handler.BackPressHandlerProvider
import com.iddevops.modbuyer.dashboard.ui.screen.home.HomeScreen

class HomeActivity : BaseActivity(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable { HomeScreen() }

    override fun onEarlyCreate() {
        super.onEarlyCreate()
        BackPressHandlerProvider.add(lifecycle, backPressHandler)
    }

    private val backPressHandler by lazy {
        object : BackPressHandler {
            override fun onBackPress() {
                activityReturnOK(NOTHING())
            }

            override fun isActive(): Boolean {
                return true
            }
        }
    }
}