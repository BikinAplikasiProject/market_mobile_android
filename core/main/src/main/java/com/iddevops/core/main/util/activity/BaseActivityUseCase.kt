package com.iddevops.core.main.util.activity

import com.iddevops.core.main.util.bootstrap.BootstrapUseCase
import com.iddevops.core.main.util.component.BaseComponentUseCase
import kotlinx.coroutines.Job

interface BaseActivityUseCase : BaseComponentUseCase, BootstrapUseCase {
    fun withScope(block: suspend () -> Unit): Job
    fun onPreCreate()
}