package com.melikeey.shortlyapppsoixd.shorten

import com.google.gson.annotations.SerializedName

data class ShortenLink (
    val code: String,

    @SerializedName("short_link")
    val shortLink: String,

    @SerializedName("full_short_link")
    val fullShortLink: String,

    @SerializedName("short_link2")
    val shortLink2: String,

    @SerializedName("full_short_link2")
    val fullShortLink2: String,

    @SerializedName("share_link")
    val shareLink: String,

    @SerializedName("full_share_link")
    val fullShareLink: String,

    @SerializedName("original_link")
    val originalLink: String
)