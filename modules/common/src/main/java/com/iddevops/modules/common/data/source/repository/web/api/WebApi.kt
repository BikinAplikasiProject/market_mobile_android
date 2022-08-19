package com.iddevops.modules.common.data.source.repository.web.api

import com.iddevops.core.main.util.retrofit.createRetrofitService
import com.iddevops.core.network.data.Secured
import com.iddevops.core.network.data.okHttpClient
import com.iddevops.modules.common.data.model.Todo
import retrofit2.http.GET

interface WebApi {
    companion object {
        val get by lazy {
            createRetrofitService(
                WebApi::class.java,
                okHttpClient,
                Secured.getBaseUrl()
            )
        }
    }

    @GET("todos/")
    fun getTodo(): List<Todo>
}
