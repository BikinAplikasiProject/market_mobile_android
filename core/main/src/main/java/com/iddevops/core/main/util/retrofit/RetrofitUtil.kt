package com.iddevops.core.main.util.retrofit

import androidx.annotation.NonNull
import arrow.core.Either
import com.iddevops.core.main.domain.model.Error
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create retrofit service
 * @author stefanus.ayudha@gmail.com
 * @param I Retrofit interface
 * @param service Class of the given Retrofit interface
 * @param httpClient OkHttp client, if you are using my codebase all u need is injecting it by parsing get() as it's param in koin module injection configuration, once you inject the core modules configuration to the Application
 * @param baseUrl Base Url of the web api
 * @return Retrofit service of the given interface
 */
fun <I> createRetrofitService(
    @NonNull service: Class<I>,
    httpClient: OkHttpClient,
    baseUrl: String,
): I = Retrofit.Builder()
    .client(httpClient)
    .baseUrl(baseUrl)
    .addCallAdapterFactory(SynchronousCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(service)

// FIXME: use this to map the response to Either<Error, T> since the EitherCallAdapterFactory is not yet ready
fun <T> responseOf(block: () -> T): Either<Error, T> = try {
    Either.Right(block.invoke())
} catch (e: Throwable) {
    Either.Left(
        Error(
            message = e.message.toString(),
            code = 0
        )
    )
}