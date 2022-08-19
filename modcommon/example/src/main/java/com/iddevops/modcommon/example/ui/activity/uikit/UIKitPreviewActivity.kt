package com.iddevops.modcommon.example.ui.activity.uikit

import androidx.compose.runtime.Composable
import com.iddevops.core.main.util.activity.BaseActivity
import com.iddevops.modcommon.example.ui.screen.uikitpreview.UIKitPreviewScreen
import com.iddevops.modcommon.example.ui.screen.uikitpreview.UiKitPreviewViewModelUseCase
import com.iddevops.modcommon.example.ui.viewmodel.UiKitPreviewViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UIKitPreviewActivity : BaseActivity() {

    private val vm: UiKitPreviewViewModelUseCase by viewModel<UiKitPreviewViewModel>()
    override val content = @Composable { UIKitPreviewScreen() }
}