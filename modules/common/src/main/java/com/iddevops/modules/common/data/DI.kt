package com.iddevops.modules.common.data

import com.iddevops.core.main.util.retrofit.createRetrofitService
import com.iddevops.modules.common.data.source.repository.web.api.WebApi
import org.koin.dsl.module

val dataModule = module {
    single {
        createRetrofitService(
            WebApi::class.java,
            get(),
            get()
        )
    }
}