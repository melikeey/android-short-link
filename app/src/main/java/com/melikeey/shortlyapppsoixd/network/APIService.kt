package com.melikeey.shortlyapppsoixd.network

import com.melikeey.shortlyapppsoixd.base.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("{url}/very/long/link.html")
    suspend fun shorten(
        @Path("url", encoded = false) url: String
    ): Response<BaseResponse>
}
