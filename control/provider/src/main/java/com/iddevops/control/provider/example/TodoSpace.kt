package com.iddevops.control.provider.example

import com.google.gson.annotations.SerializedName
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.gson.JsonConvertAble
import com.iddevops.core.main.util.navigation.BaseSpace

interface TodoSpace : BaseSpace<TodoSpace.Payload, NOTHING> {
    data class Payload(
        @field:SerializedName("nothing")
        val nothing: NOTHING = NOTHING()
    ) : JsonConvertAble
}