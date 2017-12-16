package com.andreadev.stargazerssample.exceptions

class NetworkException (cause: Throwable, message: String, val type: Type) : RuntimeException(message, cause) {

    enum class Type {
        GENERIC,
        NO_NETWORK,
        TIMEOUT
    }

    companion object {

        fun generic(cause: Throwable): NetworkException {
            return NetworkException(cause, "Generic exception", Type.GENERIC)
        }

        fun noNetwork(cause: Throwable): NetworkException {
            return NetworkException(cause, "No internet connection", Type.NO_NETWORK)
        }

        fun timeout(cause: Throwable): NetworkException {
            return NetworkException(cause, "Timeout exception", Type.TIMEOUT)
        }
    }
}
