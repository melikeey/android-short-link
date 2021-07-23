package com.melikeey.shortlyapppsoixd.base

interface BaseResponseListener<T> {

    fun onSuccess(response: T?)

    fun onError(message : String, data: T?)

    fun onLoading()
}