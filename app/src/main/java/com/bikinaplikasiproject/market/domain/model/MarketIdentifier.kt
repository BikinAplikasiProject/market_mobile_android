package com.bikinaplikasiproject.market.domain.model

import com.google.gson.annotations.SerializedName
import com.iddevops.core.main.util.gson.JsonConvertAble

data class MarketIdentifier(
    @field:SerializedName("id")
    val id: String?,
    @field:SerializedName("name")
    val name: String?,
    @field:SerializedName("imageUrl")
    val imageUrl: String?
) : JsonConvertAble