package com.example.rickandmortyandroid4lesson1.ui.fragments.poke

import com.example.rickandmortyandroid4lesson1.base.BaseViewModel
import com.example.rickandmortyandroid4lesson1.data.repositories.PokeMonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(
    private val repository: PokeMonRepository
) : BaseViewModel() {

    fun fetchPokeMons() = repository.fetchPokeMons()
}