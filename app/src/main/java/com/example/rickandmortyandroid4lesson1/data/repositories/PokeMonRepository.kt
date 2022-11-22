package com.example.rickandmortyandroid4lesson1.data.repositories

import androidx.lifecycle.liveData
import com.example.rickandmortyandroid4lesson1.common.Resource
import com.example.rickandmortyandroid4lesson1.data.remote.apiserivces.PokeApiService
import javax.inject.Inject

class PokeMonRepository @Inject constructor(
    private val service: PokeApiService
) {

    fun fetchPokeMons() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(service.fetchPokeMons()))
        } catch (exception: Exception) {
            emit(Resource.Error(message = exception.localizedMessage ?: "Error"))
        }
    }
}