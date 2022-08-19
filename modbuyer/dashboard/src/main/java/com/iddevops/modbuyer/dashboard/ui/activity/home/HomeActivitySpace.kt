package com.iddevops.modbuyer.dashboard.ui.activity.home

import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.control.provider.buyer.HomeSpace
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.launcher.createLauncher

class HomeActivitySpace : HomeSpace {
    override fun getLauncher(): ActivityResultContract<HomeSpace.Payload, NOTHING?> {
        return createLauncher(
            activity = HomeActivity::class.java,
            outputType = NOTHING::class.java
        )
    }
}