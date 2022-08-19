package com.iddevops.modules.common.ui.activity.home

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.control.module.navigator.common.HomeSpace
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.launcher.createLauncher

class HomeActivitySpace() : HomeSpace {
    override fun getLauncher(): ActivityResultContract<HomeSpace.Payload, NOTHING> {
        return createLauncher(
            { c -> Intent(c, HomeActivity::class.java) },
            outputType = NOTHING::class.java
        )
    }
}