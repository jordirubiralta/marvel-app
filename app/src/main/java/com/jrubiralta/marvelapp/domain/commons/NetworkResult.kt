package com.jrubiralta.marvelapp.domain.commons

sealed class NetworkResult<out T> {
    data class Error<T>(val message: Exception?) : NetworkResult<T>()
    data class Success<T>(val data: T) : NetworkResult<T>()
}