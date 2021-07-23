package com.melikeey.shortlyapppsoixd.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.melikeey.shortlyapppsoixd.base.BaseFragment
import com.melikeey.shortlyapppsoixd.databinding.FragmentHistoryBinding
import com.melikeey.shortlyapppsoixd.main.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HistoryFragment : BaseFragment(), HistoryAdapterCallback {

    @Inject
    lateinit var historyAdapter: HistoryAdapter

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
        val mLayoutManager =
            LinearLayoutManager(requireContext())

        binding.rv.layoutManager = mLayoutManager

        val historyList = viewModel.getDatabase().historyDao().getAll()

        historyAdapter.setItem(historyList)
        binding.rv.adapter = historyAdapter
        historyAdapter.setCallBack(this)
        historyAdapter.notifyDataSetChanged()
    }

    override fun itemDeleted(id: Int) {
        viewModel.getDatabase().historyDao().deleteById(id)
        binding.rv.adapter = historyAdapter

        if (viewModel.getDatabase().historyDao().getAll().isEmpty()) {
            binding.emptyView.visibility = View.VISIBLE
            binding.rv.visibility = View.GONE
        } else {
            binding.emptyView.visibility = View.GONE
            binding.rv.visibility = View.VISIBLE
            historyAdapter.setItem(viewModel.getDatabase().historyDao().getAll())
            historyAdapter.notifyDataSetChanged()
        }

    }
}