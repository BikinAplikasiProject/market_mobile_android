package com.iddevops.core.main.util.request

import com.iddevops.core.main.domain.model.Error

sealed class RequestState<T>
class Default<T> : RequestState<T>()
class Loading<T> : RequestState<T>()
class Success<T>(var value: T) : RequestState<T>()
class Failed<T>(val e: Error) : RequestState<T>()