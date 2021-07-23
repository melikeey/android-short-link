package com.melikeey.shortlyapppsoixd.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.melikeey.shortlyapppsoixd.main.MainActivity

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    protected abstract fun setUp(view: View?)

    fun showLoading() {
        (activity as MainActivity).showLoading()
    }

    fun hideLoading() {
        (activity as MainActivity).hideLoading()
    }

    protected fun showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(activity, getString(message), duration).show()
    }

    protected fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(activity, message, duration).show()
    }
}