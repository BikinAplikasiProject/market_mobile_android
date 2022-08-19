package com.iddevops.modbuyer.dashboard.ui

import com.iddevops.control.provider.buyer.HomeSpace
import com.iddevops.control.provider.buyer.StoreSpace
import com.iddevops.modbuyer.dashboard.ui.activity.home.HomeActivitySpace
import com.iddevops.modbuyer.dashboard.ui.activity.store.StoreActivitySpace
import org.koin.dsl.module

val uiModule = module {
    factory<HomeSpace> { HomeActivitySpace() }
    factory<StoreSpace> { StoreActivitySpace() }
}