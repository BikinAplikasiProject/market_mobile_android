package com.iddevops.core.main.util.koin

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

inline fun <reified T> getKoinInstance(): T {
    val koinObj = object : KoinComponent {
        val instance: T by inject()
    }
    return koinObj.instance
}