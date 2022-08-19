package com.iddevops.core.main.domain.payload

data class Toast(
    val message: String,
    val longToast: Boolean = false
) : Payload