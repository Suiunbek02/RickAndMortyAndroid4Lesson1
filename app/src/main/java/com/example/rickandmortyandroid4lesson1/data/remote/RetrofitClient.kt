package com.example.rickandmortyandroid4lesson1.data.remote

import com.example.rickandmortyandroid4lesson1.data.remote.apiserivces.PokeApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHttpClient() = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInspector())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInspector(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun providerPokeApiService(): PokeApiService {
        return retrofit.create(PokeApiService::class.java)
    }
}