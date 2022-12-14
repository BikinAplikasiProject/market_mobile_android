package com.iddevops.core.network.data

// use to store base URL securely by android NDK
object Secured {
    init {
        System.loadLibrary("native-lib")
    }

    external fun getBaseUrl(): String
}

const val BASE_URL = "BASE URL"