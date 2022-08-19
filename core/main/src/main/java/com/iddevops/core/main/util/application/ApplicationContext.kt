package com.iddevops.core.main.util.application

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ApplicationContext {
    private var context: Context? = null
    fun set(context: Context) {
        this.context = context
    }

    fun get(): Context {
        return this.context!!
    }
}