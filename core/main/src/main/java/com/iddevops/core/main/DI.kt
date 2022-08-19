package com.iddevops.core.main

import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreMainModule = listOf(
    module {
        factory { androidApplication() }
        factory { androidContext() }
    }
)