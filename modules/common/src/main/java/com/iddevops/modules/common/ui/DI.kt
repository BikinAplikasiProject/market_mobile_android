package com.iddevops.modules.common.ui

import com.iddevops.control.module.navigator.common.HomeSpace
import com.iddevops.modules.common.ui.activity.home.HomeActivitySpace
import com.iddevops.modules.common.ui.screen.home.vm.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    factory<HomeSpace> { HomeActivitySpace() }
    viewModel { HomeViewModel() }
}