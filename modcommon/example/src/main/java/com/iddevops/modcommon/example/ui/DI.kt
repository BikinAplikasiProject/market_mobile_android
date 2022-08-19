package com.iddevops.modcommon.example.ui

import com.iddevops.control.provider.example.TodoSpace
import com.iddevops.control.provider.example.UIKitSpace
import com.iddevops.modcommon.example.ui.activity.todolist.TodoActivitySpace
import com.iddevops.modcommon.example.ui.activity.uikit.UIKitPreviewSpace
import com.iddevops.modcommon.example.ui.viewmodel.TodoViewModel
import com.iddevops.modcommon.example.ui.viewmodel.UiKitPreviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    factory<UIKitSpace> { UIKitPreviewSpace() }
    viewModel { UiKitPreviewViewModel() }

    factory<TodoSpace> { TodoActivitySpace() }
    viewModel { TodoViewModel(get()) }
}