package com.iddevops.core.main.util.handler


interface BackPressHandler {
    fun onBackPress()
    fun isActive(): Boolean
}