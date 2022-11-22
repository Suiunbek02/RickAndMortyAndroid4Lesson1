package com.example.rickandmortyandroid4lesson1.data.remote.apiserivces

import com.example.rickandmortyandroid4lesson1.models.PokeMonResponse
import com.example.rickandmortyandroid4lesson1.models.poke.PokeModel
import retrofit2.http.GET

interface PokeApiService {

    @GET("api/v2/pokemon")
    suspend fun fetchPokeMons(): PokeMonResponse<PokeModel>
}