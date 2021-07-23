package com.melikeey.shortlyapppsoixd.network

class ApiProvider(private val apiService: APIService) {

    suspend fun shorten(url: String) = apiService.shorten(url)
}