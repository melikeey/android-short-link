package com.melikeey.shortlyapppsoixd.main

import android.app.Application
import androidx.lifecycle.liveData
import com.melikeey.shortlyapppsoixd.base.BaseViewModel
import com.melikeey.shortlyapppsoixd.database.AppDatabase
import com.melikeey.shortlyapppsoixd.network.Resource
import com.melikeey.shortlyapppsoixd.shorten.ShortenLink
import com.melikeey.shortlyapppsoixd.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
open class SharedViewModel @Inject constructor(
    private val mainRepo: MainRepository,
    application: Application
) : BaseViewModel(application) {

    @Inject
    lateinit var db: AppDatabase

    fun shorten(url: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        lateinit var shortenLinkResponse: ShortenLink

        try {
            shortenLinkResponse = mainRepo.shorten(Constants.URL_PATH + url).body()!!.result

            emit(Resource.success(data = shortenLinkResponse, message = "Error Occurred!"))

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

    fun getDatabase(): AppDatabase {
        return db
    }
}