package com.iddevops.modules.common.ui.activity.home

import androidx.compose.runtime.Composable
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.activity.ActivityResultEmitter
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.core.main.util.handler.BackPressHandler
import com.iddevops.modules.common.ui.screen.home.HomeScreen

class HomeActivity : BaseActivity(), ActivityResultEmitter<NOTHING>, BackPressHandler {
    override val content = @Composable { HomeScreen() }

    override fun onPreCreate() {
        super.onPreCreate()
        BackPressHandlerProvider.addHandler(this)
    }

    override fun onBackPress(): Boolean {
        activityReturnOK(NOTHING("from home: alksndmandlanldnandlad"))
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        BackPressHandlerProvider.removeHandler(this)
    }
}