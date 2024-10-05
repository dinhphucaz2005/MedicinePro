package com.example.medicinepro.common

sealed class ApiResult<T>(
    val data: T? = null,
    val error: String? = null
) {
    class Loading<T> : ApiResult<T>()
    class Success<T>(data: T?) : ApiResult<T>(data = data)
    class Error<T>(error: String) : ApiResult<T>(error = error)
}