package com.iddevops.control.provider.buyer

import com.google.gson.annotations.SerializedName
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.gson.JsonConvertAble
import com.iddevops.core.main.util.navigation.BaseSpace

interface HomeSpace : BaseSpace<HomeSpace.Payload, NOTHING> {
    data class Payload(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : JsonConvertAble
}