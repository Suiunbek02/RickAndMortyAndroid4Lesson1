package com.example.rickandmortyandroid4lesson1.di

import com.example.rickandmortyandroid4lesson1.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun providePokeApiService(retrofitClient: RetrofitClient) =
        retrofitClient.providerPokeApiService()
}