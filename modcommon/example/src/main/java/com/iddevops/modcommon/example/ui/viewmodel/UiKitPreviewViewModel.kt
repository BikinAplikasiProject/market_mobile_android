package com.iddevops.modcommon.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.iddevops.modcommon.example.ui.screen.uikitpreview.UiKitPreviewViewModelUseCase
import com.iddevops.modcommon.example.util.enums.ScreenTab
import kotlinx.coroutines.flow.MutableStateFlow

class UiKitPreviewViewModel : ViewModel(), UiKitPreviewViewModelUseCase {
    private val _focusedScreenTab = MutableStateFlow(ScreenTab.TYPOGRAPHY)
    override val focusedScreenTab get() = _focusedScreenTab
    override fun setFocusedScreenTab(tab: ScreenTab) {
        _focusedScreenTab.value = tab
    }
}