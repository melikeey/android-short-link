package com.melikeey.shortlyapppsoixd.shorten

import com.melikeey.shortlyapppsoixd.base.BaseResponseListener

interface ShortenView : BaseResponseListener<ShortenLink> {
    fun onSubmit()
}