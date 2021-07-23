package com.melikeey.shortlyapppsoixd.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.melikeey.shortlyapppsoixd.main.MainRepository

import javax.inject.Inject

open class BaseViewModel @Inject constructor(
    shortenApp: Application
) : AndroidViewModel(shortenApp) {

    @Inject
    lateinit var mainRepository: MainRepository

}