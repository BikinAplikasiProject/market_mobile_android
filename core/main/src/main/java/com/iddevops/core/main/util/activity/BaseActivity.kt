package com.iddevops.core.main.util.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.iddevops.core.main.util.handler.BackPressHandlerProvider
import com.iddevops.core.main.util.setupScreenSize
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseActivity : ComponentActivity(), BaseActivityUseCase {

    override val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onEarlyCreate()

        setContent {
            val configuration = remember {
                LocalConfiguration
            }
            setupScreenSize(
                configuration.current.screenWidthDp.dp,
                configuration.current.screenHeightDp.dp,
                false
            )
            content()
        }

        initData()
        initUI()
        initObserver()
        initAction()
    }

    override fun onEarlyCreate() {}

    override fun initData() {}

    override fun initUI() {}

    override fun initObserver() {}

    override fun initAction() {}

    override fun withScope(block: suspend () -> Unit): Job {
        return lifecycleScope.launch {
            block.invoke()
        }
    }

    abstract val content: @Composable () -> Unit

    final override fun onBackPressed() {
        BackPressHandlerProvider.getActiveHandler()?.onBackPress()
            ?: super.onBackPressed()
    }
}