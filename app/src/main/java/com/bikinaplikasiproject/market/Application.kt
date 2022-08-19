package com.bikinaplikasiproject.market

import com.iddevops.core.main.coreMainModule
import com.iddevops.core.main.util.application.BaseApplication
import com.iddevops.core.network.coreNetworkModules
import com.iddevops.core.ui.coreUIModules
import com.iddevops.modules.common.commonModules
import com.iddevops.modules.uikit.uikitModules
import org.koin.core.module.Module

class Application : BaseApplication() {

    override val modules = arrayListOf<Module>().apply {
        addAll(coreMainModule)
        addAll(coreNetworkModules)
        addAll(coreUIModules)
        addAll(commonModules)
        addAll(uikitModules)
    }
}