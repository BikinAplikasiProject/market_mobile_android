package com.iddevops.core.main.util.bootstrap

interface BootstrapUseCase {
    fun initData()
    fun initUI()
    fun initAction()
    fun initObserver()
}