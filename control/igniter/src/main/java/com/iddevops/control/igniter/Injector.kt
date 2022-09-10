package com.iddevops.control.igniter

import com.example.modwebadmin.dashboard.modWebDashboardModules
import com.iddevops.core.main.coreMainModules
import com.iddevops.core.network.coreNetworkModules
import com.iddevops.core.ui.coreUIModules
import com.iddevops.modbuyer.dashboard.modBuyerDashboardModules
import com.iddevops.modcommon.example.modCommonExampleModules

val allModules = listOf(
    *coreMainModules.toTypedArray(),
    *coreNetworkModules.toTypedArray(),
    *coreUIModules.toTypedArray(),

    *modCommonExampleModules.toTypedArray(),
    *modBuyerDashboardModules.toTypedArray(),
    *modWebDashboardModules.toTypedArray()
)