package com.example.fetchtakehome_josephgalante.di

import com.example.fetchtakehome_josephgalante.data.remote.Api
import com.example.fetchtakehome_josephgalante.data.remote.Utils
import com.example.fetchtakehome_josephgalante.data.repository.ApiRepository
import com.example.fetchtakehome_josephgalante.data.repository.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder()
            .baseUrl(Utils.Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideApiRepository(api: Api): ApiRepository {
        return ApiRepositoryImpl(api)
    }
}