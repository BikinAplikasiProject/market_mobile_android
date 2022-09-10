package com.bikinaplikasiproject.market.ui.activity.splash

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.bikinaplikasiproject.market.ui.screen.smart.SmartScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.iddevops.control.provider.buyer.HomeSpace
import com.iddevops.control.provider.buyer.StoreSpace
import com.iddevops.control.provider.example.TodoSpace
import com.iddevops.control.provider.example.UIKitSpace
import com.iddevops.control.provider.web.WebHomeSpace
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.core.main.util.activity.createLauncher
import com.iddevops.core.main.util.coroutine.LaunchInIO
import com.iddevops.core.main.util.logDebug
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SmartSplashActivity : BaseActivity() {

    private val uiKitSpace: UIKitSpace by inject()
    private val todoSpace: TodoSpace by inject()
    private val homeSpace: HomeSpace by inject()
    private val storeSpace: StoreSpace by inject()
    private val webHomeSpace: WebHomeSpace by inject()

    private val uiKitLauncher = createLauncher(uiKitSpace) {
        logDebug("pouipuyouyqwouyowq UI KIT $it")
    }
    private val todoLauncher = createLauncher(todoSpace) {
        logDebug("pouipuyouyqwouyowq TODO $it")
    }
    private val homeLauncher = createLauncher(homeSpace) {
        logDebug("pouipuyouyqwouyowq HOME $it")
    }
    private val storeLauncher = createLauncher(storeSpace) {
        logDebug("pouipuyouyqwouyowq STORE $it")
    }
    private val webHomeLauncher = createLauncher(webHomeSpace) {
        logDebug("pouipuyouyqwouyowq WEB HOME $it")
    }

    override val content = @Composable {
        SmartScreen(
            rememberSystemUiController(),
            storeLauncher
        )
    }

    override fun initAction() {
        LaunchInIO {
            webHomeLauncher.launch(
                WebHomeSpace.Payload()
            )
        }
    }
}

