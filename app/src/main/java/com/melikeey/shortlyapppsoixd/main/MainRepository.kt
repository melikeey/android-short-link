package com.melikeey.shortlyapppsoixd.main

import com.melikeey.shortlyapppsoixd.network.ApiProvider
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiProvider: ApiProvider){

    suspend fun shorten(url: String) = apiProvider.shorten(url)
}