package com.example.modwebadmin.dashboard.ui.activity.home

import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.control.provider.web.WebHomeSpace
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.launcher.createLauncher

class WebHomeActivitySpace : WebHomeSpace {
    override fun getLauncher(): ActivityResultContract<WebHomeSpace.Payload, NOTHING?> {
        return createLauncher(
            WebHomeActivity::class.java,
            NOTHING::class.java
        )
    }
}