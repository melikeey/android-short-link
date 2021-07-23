package com.melikeey.shortlyapppsoixd.base

import com.google.gson.annotations.SerializedName
import com.melikeey.shortlyapppsoixd.shorten.ShortenLink

data class BaseResponse (

    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: ShortenLink
)