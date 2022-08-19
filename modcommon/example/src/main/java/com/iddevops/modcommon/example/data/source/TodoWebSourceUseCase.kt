package com.iddevops.modcommon.example.data.source

import arrow.core.Either
import com.iddevops.core.main.domain.model.Error
import com.iddevops.modcommon.example.domain.model.Todo
import com.iddevops.modcommon.example.domain.payload.TodoPayload

fun interface GetTodoListWeb {
    suspend fun exec(payload: TodoPayload): Either<Error, List<Todo>>
}