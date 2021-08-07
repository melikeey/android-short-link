package com.melikeey.shortlyapppsoixd.shorten

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.melikeey.shortlyapppsoixd.R
import com.melikeey.shortlyapppsoixd.base.BaseFragment
import com.melikeey.shortlyapppsoixd.database.History
import com.melikeey.shortlyapppsoixd.databinding.FragmentShortenBinding
import com.melikeey.shortlyapppsoixd.main.MainActivity
import com.melikeey.shortlyapppsoixd.main.SharedViewModel
import com.melikeey.shortlyapppsoixd.network.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShortenFragment : BaseFragment(), ShortenView, View.OnClickListener {

    private lateinit var binding: FragmentShortenBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var isAllDataLoaded: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShortenBinding.inflate(inflater, container, false)
        (requireActivity() as MainActivity).supportActionBar!!.hide()

        return binding.root
    }

    override fun setUp(view: View?) {
        binding.btnShorten.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnShorten.id -> onSubmit()
        }
    }

    override fun onSubmit() {
        if (checkValidUrl()) {
            makeShortLink()
        } else {
            binding.etShortenUrl.error = getString(R.string.et_error_text)
        }
    }

    private fun makeShortLink() {
        binding.btnShorten.isEnabled = false

        viewModel.shorten(binding.etShortenUrl.text.toString()).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> onSuccess(it.data)
                Resource.Status.ERROR -> onError(it.message.toString(), it.data)
                Resource.Status.LOADING -> onLoading()
            }
        })
    }

    private fun checkValidUrl(): Boolean {
        var isValid = false
        if (binding.etShortenUrl.text.toString().isNotEmpty()) {
            if (android.util.Patterns.WEB_URL.matcher(binding.etShortenUrl.text.toString()).matches()){
              isValid = true
            }
        }

        return isValid
    }

    override fun onSuccess(response: ShortenLink?) {
        hideLoading()
        binding.progressBottom.visibility = View.GONE

        response!!.let {

            viewModel.getDatabase().historyDao().insert(History(
                    binding.etShortenUrl.text.toString(), response.shortLink,
                )
            )

            Navigation.findNavController(
                requireActivity(),
                R.id.nav_host
            ).navigate(R.id.historyFragment)

        }
    }

    override fun onError(message: String, data: ShortenLink?) {
        hideLoading()

        binding.progressBottom.visibility = View.GONE
        isAllDataLoaded = true

        showToast(message)
    }

    override fun onLoading() {
        showLoading()
    }
}