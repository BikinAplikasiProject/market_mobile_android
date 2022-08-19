package com.iddevops.modcommon.example.domain.payload

import com.iddevops.core.main.domain.payload.Payload

data class TodoPayload(
    val id: String? = null
) : Payload