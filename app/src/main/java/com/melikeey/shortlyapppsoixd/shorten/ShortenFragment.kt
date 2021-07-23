package com.melikeey.shortlyapppsoixd.shorten

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.melikeey.shortlyapppsoixd.base.BaseFragment
import com.melikeey.shortlyapppsoixd.databinding.FragmentShortenBinding
import com.melikeey.shortlyapppsoixd.main.SharedViewModel
import com.melikeey.shortlyapppsoixd.network.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShortenFragment : BaseFragment(), ShortenView {

    private lateinit var binding: FragmentShortenBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var isAllDataLoaded: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShortenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun setUp(view: View?) {

    }

    override fun onSubmit() {
        makeShortLink()
    }

    private fun makeShortLink() {
        viewModel.shorten("").observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> onSuccess(it.data)
                Resource.Status.ERROR -> onError(it.message.toString(), it.data)
                Resource.Status.LOADING -> onLoading()
            }
        })    }

    override fun onSuccess(response: ShortenLink?) {
        hideLoading()
        binding.progressBottom.visibility = View.GONE

            response!!.let {

        }
    }

    override fun onError(message: String, data: ShortenLink?) {
        hideLoading()

        binding.progressBottom.visibility = View.GONE
        isAllDataLoaded = true
    }

    override fun onLoading() {
        showLoading()
    }
}