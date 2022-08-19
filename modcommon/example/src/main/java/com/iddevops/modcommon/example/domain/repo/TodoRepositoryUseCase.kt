package com.iddevops.modcommon.example.domain.repo

import arrow.core.Either
import com.iddevops.core.main.domain.model.Error
import com.iddevops.modcommon.example.domain.model.Todo
import com.iddevops.modcommon.example.domain.payload.TodoPayload

fun interface GetTodoListRepository {
    suspend fun exec(payload: TodoPayload): Either<Error, List<Todo>>
}