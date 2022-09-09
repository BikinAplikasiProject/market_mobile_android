package com.iddevops.modbuyer.dashboard.ui.screen.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.main.util.toDp
import com.iddevops.core.ui.ui.theme.ContentThemeWrapper
import com.iddevops.core.ui.ui.theme.color.NeutralBlack

@Composable
fun StoreScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        BlackCodeScanner()
    }
}


@Composable
fun BlackCodeScanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.toDp)
            .background(color = NeutralBlack)
    ) {
        AdminClubMembershipScanScreen()
    }
}

@Composable
fun AdminClubMembershipScanScreen() {
    val context = LocalContext.current
    val scanFlag = remember {
        mutableStateOf(false)
    }

//    val compoundBarcodeView = remember {
//        CompoundBarcodeView(context).apply {
//            val capture = CaptureManager(context as Activity, this)
//            capture.initializeFromIntent(context.intent, null)
//            this.setStatusText("")
//            capture.decode()
//            this.decodeContinuous { result ->
//                if (scanFlag.value) {
//                    return@decodeContinuous
//                }
//                scanFlag.value = true
//                result.text?.let { barCodeOrQr ->
//                    logDebug("kajbsdkasbdkajsb $barCodeOrQr")
//                    scanFlag.value = false
//                }
//                //If you don't put this scanFlag = false, it will never work again.
//                //you can put a delay over 2 seconds and then scanFlag = false to prevent multiple scanning
//
//            }
//        }
//    }

//    AndroidView(
//        modifier = Modifier,
//        factory = { compoundBarcodeView },
//    )
}

@Composable
@Preview(showSystemUi = true)
fun Preview1() {
    ContentThemeWrapper {
        StoreScreen()
    }
}