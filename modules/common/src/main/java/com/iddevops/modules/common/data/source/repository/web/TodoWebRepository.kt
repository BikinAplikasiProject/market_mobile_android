package com.iddevops.modules.common.data.source.repository.web

import com.iddevops.core.main.util.retrofit.responseOf
import com.iddevops.modules.common.data.source.repository.web.api.WebApi

val getTodoListWeb = GetTodoListWeb {
    responseOf { WebApi.get.getTodo() }
}