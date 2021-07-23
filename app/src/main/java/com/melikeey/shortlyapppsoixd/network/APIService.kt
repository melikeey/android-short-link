package com.melikeey.shortlyapppsoixd.network

import com.melikeey.shortlyapppsoixd.shorten.ShortenLink
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("shorten/")
    suspend fun shorten(
        @Body url: String
    ): Response<ShortenLink>
}
