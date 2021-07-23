package com.melikeey.shortlyapppsoixd.di

import com.melikeey.shortlyapppsoixd.main.MainRepository
import com.melikeey.shortlyapppsoixd.network.APIService
import com.melikeey.shortlyapppsoixd.network.ApiProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMainRepository(apiProvider: ApiProvider) = MainRepository(apiProvider)

    @Singleton
    @Provides
    fun provideApiProvider(apiService: APIService) =
        ApiProvider(apiService)
}