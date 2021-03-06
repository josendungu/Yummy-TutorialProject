package com.example.yummy.di

import android.content.Context
import com.example.yummy.YummyApplication
import com.example.yummy.common.Constants
import com.example.yummy.data.remote.Food2ForkApi
import com.example.yummy.data.repository.Food2ForkRepositoryImpl
import com.example.yummy.domain.repository.Food2ForkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): YummyApplication {
        return app as YummyApplication
    }
}