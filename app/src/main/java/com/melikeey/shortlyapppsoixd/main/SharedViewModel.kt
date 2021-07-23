package com.melikeey.shortlyapppsoixd.main

import android.app.Application
import androidx.lifecycle.liveData
import com.melikeey.shortlyapppsoixd.base.BaseViewModel
import com.melikeey.shortlyapppsoixd.network.Resource
import com.melikeey.shortlyapppsoixd.shorten.ShortenLink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
open class SharedViewModel @Inject constructor(
    private val mainRepo: MainRepository,
    application: Application
) : BaseViewModel(application) {

    var app: Application = application

    fun shorten(strReq: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        lateinit var shortedLinkResponse: ShortenLink

        try {
            shortedLinkResponse = mainRepo.shorten("shorten?url=google.com").body()!!.result

            // shortLinkLiveData.postValue(shortedLinkResponse)

            emit(Resource.success(data = shortedLinkResponse, message = "Error Occurred!"))

        } catch (exception: Exception) {
            exception.printStackTrace()
            emit(
                Resource.error(
                    data = null,
                    message = exception.message ?: "Error Occurred!"
                )
            )
        }
    }
}