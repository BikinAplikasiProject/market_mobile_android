package com.iddevops.modcommon.example.ui.viewmodel

import arrow.core.Either
import com.iddevops.core.main.domain.model.Error
import com.iddevops.core.main.util.viewmodel.BaseViewModel
import com.iddevops.modcommon.example.domain.model.Todo
import com.iddevops.modcommon.example.domain.payload.TodoPayload
import com.iddevops.modcommon.example.domain.repo.GetTodoListRepository
import com.iddevops.modcommon.example.ui.screen.todolist.TodoViewModelUseCase

class TodoViewModel(
    private val getTodoList: GetTodoListRepository
) : BaseViewModel(), TodoViewModelUseCase {

    val todoListState = object : State<List<Todo>, TodoPayload>() {
        override val operator: suspend (TodoPayload) -> Either<Error, List<Todo>>
            get() = { getTodoList.exec(it) }
    }

    override fun clear() {
        todoListState.resetClear()
    }
}