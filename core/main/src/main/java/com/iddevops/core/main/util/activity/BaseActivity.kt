package com.iddevops.core.main.util.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.iddevops.core.main.util.handler.BackPressHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseActivity : ComponentActivity(), BaseActivityUseCase {

    object BackPressHandlerProvider {
        private val handlers = arrayListOf<BackPressHandler>()

        fun onBackPress(): Boolean {
            return try {
                handlers.last().onBackPress()
            } catch (e: Throwable) {
                false
            }
        }

        fun addHandler(handler: BackPressHandler) {
            handlers.add(handler)
        }

        fun removeHandler(handler: BackPressHandler) {
            handlers.remove(handler)
        }
    }

    override val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        onPreCreate()

        super.onCreate(savedInstanceState)
        setContent(content = content)

        initData()
        initUI()
        initObserver()
        initAction()
    }

    override fun onPreCreate() {}

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

    override fun onBackPressed() {
        if (BackPressHandlerProvider.onBackPress().not()) {
            moveTaskToBack(true)
        }
    }
}