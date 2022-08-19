package com.iddevops.modules.uikit.ui.activity

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.control.module.navigator.uikit.UIKitSpace
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.launcher.createLauncher

class UIKitPreviewSpace : UIKitSpace {
    override fun getLauncher(): ActivityResultContract<UIKitSpace.Payload, NOTHING> {
        return createLauncher(
            { c -> Intent(c, UIKitPreviewActivity::class.java) },
            outputType = NOTHING::class.java
        )
    }
}