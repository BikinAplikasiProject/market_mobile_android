package com.iddevops.modules.common.data.source

import arrow.core.Either
import com.iddevops.core.main.domain.model.Error
import com.iddevops.modules.common.data.model.Todo
import com.iddevops.modules.common.data.payload.TodoPayload

fun interface GetTodoListSource {
    suspend fun exec(payload: TodoPayload): Either<Error, List<Todo>>
}