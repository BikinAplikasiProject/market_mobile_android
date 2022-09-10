package com.example.modwebadmin.dashboard.ui.activity.home

import androidx.compose.runtime.Composable
import com.example.modwebadmin.dashboard.ui.screen.home.HomeScreen
import com.iddevops.core.main.util.activity.BaseActivity

class WebHomeActivity : BaseActivity() {
    override val content = @Composable { HomeScreen() }
}