package com.iddevops.core.main.util.activity

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.iddevops.core.main.util.navigation.BaseSpace

fun <P, O> BaseActivity.createLauncher(
    space: BaseSpace<P, O>,
    callback: ActivityResultCallback<O?>
): ActivityResultLauncher<P> {
    return registerForActivityResult(space.getLauncher(), callback)
}