package com.iddevops.core.main.domain.model

import com.google.gson.annotations.SerializedName
import com.iddevops.core.main.util.gson.JsonConvertAble

data class NOTHING(
    @field:SerializedName("value")
    private val value: String? = null
) : JsonConvertAble