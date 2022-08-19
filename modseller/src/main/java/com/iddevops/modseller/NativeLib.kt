package com.iddevops.modseller

class NativeLib {

    /**
     * A native method that is implemented by the 'modseller' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'modseller' library on application startup.
        init {
            System.loadLibrary("modseller")
        }
    }
}