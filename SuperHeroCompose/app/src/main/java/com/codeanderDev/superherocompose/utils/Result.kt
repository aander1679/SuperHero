package com.codeanderDev.superherocompose.utils

import com.codeanderDev.superherocompose.data.model.Hero

sealed class Result <T>(val data:T?=null,val message: String? = null) {
    class Sucess<T>(data:T ): Result<T>(data)
    class Error<T>(message: String, data:T?=null): Result<T>(data,message)

}