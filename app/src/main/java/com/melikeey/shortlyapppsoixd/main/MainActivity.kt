package com.melikeey.shortlyapppsoixd.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.melikeey.shortlyapppsoixd.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var isProgressHidedBefore = false
    private var isLoading = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    internal fun showLoading() {
        isLoading = true
        isProgressHidedBefore = false
        lifecycleScope.launch {
            delay(2000)
            if (!isProgressHidedBefore) {
                binding.rlCustomPb.visibility = View.VISIBLE
                binding.navHost.visibility = View.GONE
            }
        }
    }

    internal fun hideLoading() {
        isLoading = false
        isProgressHidedBefore = true
        binding.rlCustomPb.visibility = View.GONE
        binding.navHost.visibility = View.VISIBLE
    }
}