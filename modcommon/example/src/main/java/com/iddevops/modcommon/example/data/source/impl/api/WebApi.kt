package com.iddevops.modcommon.example.data.source.impl.api

import com.iddevops.modcommon.example.domain.model.Todo
import retrofit2.http.GET

interface WebApi {
    @GET("todos/")
    fun getTodo(): List<Todo>
}
