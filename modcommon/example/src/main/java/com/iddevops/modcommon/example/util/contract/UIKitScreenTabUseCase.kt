package com.iddevops.modcommon.example.util.contract

import com.iddevops.modcommon.example.util.enums.ScreenTab
import kotlinx.coroutines.flow.StateFlow

interface UIKitScreenTabUseCase {
    val focusedScreenTab: StateFlow<ScreenTab>
    fun setFocusedScreenTab(tab: ScreenTab)
}