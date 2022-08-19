package com.iddevops.core.main.domain.model

import com.google.gson.annotations.SerializedName

data class Data<T>(
    @field:SerializedName("data")
    val data: T?
)