package com.melikeey.shortlyapppsoixd.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.melikeey.shortlyapppsoixd.base.BaseFragment
import com.melikeey.shortlyapppsoixd.databinding.FragmentHistoryBinding
import com.melikeey.shortlyapppsoixd.main.SharedViewModel
import com.melikeey.shortlyapppsoixd.shorten.ShortenLink
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HistoryFragment : BaseFragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun setUp(view: View?) {
        val shortenLink = arguments?.getParcelable<ShortenLink>("link") as ShortenLink
        binding.tvHistory.text = shortenLink.shortLink
    }

}