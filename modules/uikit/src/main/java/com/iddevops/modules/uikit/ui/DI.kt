package com.iddevops.modules.uikit.ui

import com.iddevops.control.module.navigator.uikit.UIKitSpace
import com.iddevops.modules.uikit.ui.activity.UIKitPreviewSpace
import com.iddevops.modules.uikit.ui.viewmodel.UiKitPreviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    factory<UIKitSpace> { UIKitPreviewSpace() }
    viewModel { UiKitPreviewViewModel() }
}