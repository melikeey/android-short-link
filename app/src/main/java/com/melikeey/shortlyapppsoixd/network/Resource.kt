package com.melikeey.shortlyapppsoixd.network

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val code: Double?
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T, message: String?): Resource<T> {
            return Resource(Status.SUCCESS, data, message, 200.0)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message, 500.0)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null, 0.0)
        }
    }
}