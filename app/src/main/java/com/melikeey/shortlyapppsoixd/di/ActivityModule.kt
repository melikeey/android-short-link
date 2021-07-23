package com.melikeey.shortlyapppsoixd.di

import com.melikeey.shortlyapppsoixd.history.HistoryAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun provideHistoryAdapter() = HistoryAdapter()
}