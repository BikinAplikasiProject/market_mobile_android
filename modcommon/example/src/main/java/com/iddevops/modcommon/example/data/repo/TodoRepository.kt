package com.iddevops.modcommon.example.data.repo

import com.iddevops.core.main.util.koin.getKoinInstance
import com.iddevops.modcommon.example.data.source.GetTodoListWeb
import com.iddevops.modcommon.example.domain.repo.GetTodoListRepository

fun getTodoList() = GetTodoListRepository {
    val webApi: GetTodoListWeb = getKoinInstance()
    val webResponse = webApi.exec(it)
    webResponse
}