package com.iddevops.basecompose.ui.activity.main

import androidx.compose.runtime.Composable
import com.iddevops.basecompose.ui.screen.main.MainScreen
import com.iddevops.control.module.navigator.common.HomeSpace
import com.iddevops.control.module.navigator.uikit.UIKitSpace
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.core.main.util.activity.createLauncher
import com.iddevops.core.main.util.coroutine.LaunchInIO
import com.iddevops.core.main.util.logDebug
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    private val uiKitSpace: UIKitSpace by inject()
    private val homeSpace: HomeSpace by inject()

    private val uiKitLauncher = createLauncher(uiKitSpace) {
        logDebug("pouipuyouyqwouyowq UI KIT $it")
    }
    private val homeLauncher = createLauncher(homeSpace) {
        logDebug("pouipuyouyqwouyowq HOME $it")
    }

    override val content = @Composable {
        MainScreen(name = "Base Project")
    }

    override fun initAction() {
        LaunchInIO {
            homeLauncher.launch(
                HomeSpace.Payload()
            )
        }
    }
}

