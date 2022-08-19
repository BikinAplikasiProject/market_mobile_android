package com.iddevops.modules.common.ui.screen.home.vm

import arrow.core.Either
import com.iddevops.core.main.domain.model.Error
import com.iddevops.core.main.util.viewmodel.BaseViewModel
import com.iddevops.modules.common.data.model.Todo
import com.iddevops.modules.common.data.payload.TodoPayload
import com.iddevops.modules.common.data.source.getTodoList

class HomeViewModel : BaseViewModel() {
    val todoListState = object : State<List<Todo>, TodoPayload>() {
        override val operator: suspend (TodoPayload) -> Either<Error, List<Todo>>
            get() = { getTodoList.exec(it) }
    }

    override fun clear() {
        todoListState.resetClear()
    }
}