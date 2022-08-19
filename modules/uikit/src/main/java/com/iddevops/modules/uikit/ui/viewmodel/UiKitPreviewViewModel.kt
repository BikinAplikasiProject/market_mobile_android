package com.iddevops.modules.uikit.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.iddevops.modules.uikit.util.enum.ScreenTab
import kotlinx.coroutines.flow.MutableStateFlow

class UiKitPreviewViewModel : ViewModel(), UiKitPreviewViewModelUseCase {
    private val _focusedScreenTab = MutableStateFlow(ScreenTab.TYPOGRAPHY)
    override val focusedScreenTab get() = _focusedScreenTab
    override fun setFocusedScreenTab(tab: ScreenTab) {
        _focusedScreenTab.value = tab
    }
}