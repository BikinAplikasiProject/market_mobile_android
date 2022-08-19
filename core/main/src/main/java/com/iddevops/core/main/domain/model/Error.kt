package com.iddevops.core.main.domain.model

import com.google.gson.annotations.SerializedName
import com.iddevops.core.main.util.gson.JsonConvertAble

data class Error(
    @field:SerializedName("message")
    val message: String?,
    @field:SerializedName("code")
    val code: Int?
) : JsonConvertAble