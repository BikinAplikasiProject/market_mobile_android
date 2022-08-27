package com.iddevops.core.main.util.activity

import com.iddevops.core.main.util.bootstrap.BootstrapUseCase
import com.iddevops.core.main.util.component.BaseComponentUseCase
import kotlinx.coroutines.Job

interface BaseActivityUseCase : BaseComponentUseCase, BootstrapUseCase {
    fun withScope(block: suspend () -> Unit): Job

    /**
     * On early create - This scope run in onCreate() before everything else.
     * This function guarantee the lifecycle is already created when it launched.
     *
     */
    fun onEarlyCreate()
}