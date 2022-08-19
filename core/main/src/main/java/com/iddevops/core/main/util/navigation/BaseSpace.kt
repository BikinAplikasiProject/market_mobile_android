package com.iddevops.core.main.util.navigation

import androidx.activity.result.contract.ActivityResultContract

interface BaseSpace<P, O> {
    fun getLauncher(): ActivityResultContract<P, O>
}