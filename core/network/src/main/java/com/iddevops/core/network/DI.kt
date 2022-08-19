package com.iddevops.core.network

import com.iddevops.core.network.data.dataModule
import org.koin.core.module.Module

val coreNetworkModules = listOf<Module>(
    dataModule
)