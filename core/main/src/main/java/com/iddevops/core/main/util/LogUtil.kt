package com.iddevops.core.main.util

import android.util.Log

fun Any.logDebug(msg: String) {
    Log.d(this.javaClass.simpleName, msg)
}

fun logDebug(msg: String) {
    Log.d("NOWHERE", msg)
}