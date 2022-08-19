package com.iddevops.modcommon.example.data.source.impl.impl

import com.iddevops.core.main.util.koin.getKoinInstance
import com.iddevops.core.main.util.retrofit.responseToEither
import com.iddevops.modcommon.example.data.source.GetTodoListWeb
import com.iddevops.modcommon.example.data.source.impl.api.WebApi

fun getTodoListWeb() = GetTodoListWeb {
    val api: WebApi = getKoinInstance()
    val response = api.getTodo()
    responseToEither { response }
}