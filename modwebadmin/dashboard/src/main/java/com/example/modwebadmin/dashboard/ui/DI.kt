package com.example.modwebadmin.dashboard.ui

import com.example.modwebadmin.dashboard.ui.activity.home.WebHomeActivitySpace
import com.iddevops.control.provider.web.WebHomeSpace
import org.koin.dsl.module

val uiModule = module {
    factory<WebHomeSpace> { WebHomeActivitySpace() }
}