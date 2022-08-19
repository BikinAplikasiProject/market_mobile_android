package com.iddevops.modules.common.data.source

import com.iddevops.modules.common.data.source.repository.web.getTodoListWeb

val getTodoList = GetTodoListSource {
    getTodoListWeb.exec(it)
}