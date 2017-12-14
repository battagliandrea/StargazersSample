package com.andreadev.kotlinmvp.api

/**
 * Created by andrea on 27/08/2017.
 */
class BaseResponse(val et: ErrorType) : Throwable(){

    enum class ErrorType {
        NO_INTERNET_CONNECTION,
        TIMEOUT,
        UNEXPECTED,
        HTTP
    }

    var errorType = et
    var rawMessage: String? = null
    var status: Int? = null
}