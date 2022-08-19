package com.iddevops.modbuyer.dashboard.ui.activity.store

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.activity.ActivityResultEmitter
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.core.main.util.handler.BackPressHandler

class StoreActivity : BaseActivity(), ActivityResultEmitter<NOTHING> {
    override val content = @Composable {
        Text(text = "kasjdkjabdkbas")
    }

    override fun onEarlyCreate() {
        super.onEarlyCreate()

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