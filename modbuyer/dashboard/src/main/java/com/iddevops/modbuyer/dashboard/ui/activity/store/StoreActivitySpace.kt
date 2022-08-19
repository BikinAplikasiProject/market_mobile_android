package com.iddevops.modbuyer.dashboard.ui.activity.store

import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.control.provider.buyer.StoreSpace
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.launcher.createLauncher

class StoreActivitySpace : StoreSpace {
    override fun getLauncher(): ActivityResultContract<StoreSpace.Payload, NOTHING?> {
        return createLauncher(
            activity = StoreActivity::class.java,
            outputType = NOTHING::class.java
        )
    }
}