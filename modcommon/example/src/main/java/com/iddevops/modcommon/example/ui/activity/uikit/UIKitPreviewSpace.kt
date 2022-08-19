package com.iddevops.modcommon.example.ui.activity.uikit

import androidx.activity.result.contract.ActivityResultContract
import com.iddevops.control.provider.example.UIKitSpace
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.launcher.createLauncher

class UIKitPreviewSpace : UIKitSpace {
    override fun getLauncher(): ActivityResultContract<UIKitSpace.Payload, NOTHING?> {
        return createLauncher(
            activity = UIKitPreviewActivity::class.java,
            outputType = NOTHING::class.java
        )
    }
}