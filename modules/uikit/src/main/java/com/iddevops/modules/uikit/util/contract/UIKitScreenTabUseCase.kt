package com.iddevops.modules.uikit.util.contract

import com.iddevops.modules.uikit.util.enum.ScreenTab
import kotlinx.coroutines.flow.StateFlow

interface UIKitScreenTabUseCase {
    val focusedScreenTab: StateFlow<ScreenTab>
    fun setFocusedScreenTab(tab: ScreenTab)
}