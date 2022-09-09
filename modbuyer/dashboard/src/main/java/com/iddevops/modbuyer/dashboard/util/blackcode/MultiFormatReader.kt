package com.iddevops.modbuyer.dashboard.util.blackcode

import com.google.zxing.BarcodeFormat
import com.google.zxing.DecodeHintType
import com.google.zxing.MultiFormatReader
import java.nio.charset.StandardCharsets

val blackCodeAcceptedFormats = arrayListOf(
    *BarcodeFormat.values().toList().toTypedArray()
)

val multiFormatReaderHints = mapOf(
    DecodeHintType.TRY_HARDER to true,
    DecodeHintType.POSSIBLE_FORMATS to blackCodeAcceptedFormats,
    DecodeHintType.CHARACTER_SET to StandardCharsets.UTF_8.name()
)

val multiFormatReader = MultiFormatReader().apply {
    setHints(multiFormatReaderHints)
}