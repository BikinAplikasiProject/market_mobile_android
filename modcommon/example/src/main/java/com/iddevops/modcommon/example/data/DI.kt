package com.iddevops.modcommon.example.data

import com.iddevops.core.main.util.retrofit.createRetrofitService
import com.iddevops.core.network.data.BASE_URL
import com.iddevops.modcommon.example.data.repo.getTodoList
import com.iddevops.modcommon.example.data.source.GetTodoListWeb
import com.iddevops.modcommon.example.data.source.impl.api.WebApi
import com.iddevops.modcommon.example.data.source.impl.impl.getTodoListWeb
import com.iddevops.modcommon.example.domain.repo.GetTodoListRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory<GetTodoListRepository> {
        getTodoList()
    }
    factory<GetTodoListWeb> {
        getTodoListWeb()
    }
    single {
        createRetrofitService(
            WebApi::class.java,
            get(),
            get(named(BASE_URL))
        )
    }
}