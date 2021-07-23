package com.melikeey.shortlyapppsoixd.di

import android.content.Context
import androidx.room.Room
import com.melikeey.shortlyapppsoixd.database.AppDatabase
import com.melikeey.shortlyapppsoixd.main.MainRepository
import com.melikeey.shortlyapppsoixd.network.APIService
import com.melikeey.shortlyapppsoixd.network.ApiProvider
import com.melikeey.shortlyapppsoixd.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    fun provideDB(@ApplicationContext context: Context) =  Room.databaseBuilder(
        context,
        AppDatabase::class.java, Constants.DB_NAME
    ).allowMainThreadQueries().build()

}