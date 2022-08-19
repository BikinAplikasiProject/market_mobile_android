package com.iddevops.modules.uikit.ui.activity

import androidx.compose.runtime.Composable
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.modules.uikit.ui.screen.uikitpreview.UIKitPreviewScreen
import com.iddevops.modules.uikit.ui.viewmodel.UiKitPreviewViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UIKitPreviewActivity : BaseActivity() {

    private val vm by viewModel<UiKitPreviewViewModel>()
    override val content = @Composable { UIKitPreviewScreen() }
}