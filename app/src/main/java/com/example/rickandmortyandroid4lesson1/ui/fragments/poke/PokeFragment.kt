package com.example.rickandmortyandroid4lesson1.ui.fragments.poke

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyandroid4lesson1.R
import com.example.rickandmortyandroid4lesson1.base.BaseFragment
import com.example.rickandmortyandroid4lesson1.common.Resource
import com.example.rickandmortyandroid4lesson1.databinding.FragmentPokeBinding
import com.example.rickandmortyandroid4lesson1.ui.adapters.PokeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeFragment :
    BaseFragment<FragmentPokeBinding, PokeViewModel>(R.layout.fragment_poke) {

    override val binding by viewBinding(FragmentPokeBinding::bind)
    override val viewModel: PokeViewModel by viewModels()
    private val pokeAdapter = PokeAdapter()

    override fun setupSubscribes() {
        subscribeToPokeMons()
    }

    override fun initialize() {
        binding.pokeMonRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokeAdapter
        }
    }

    private fun subscribeToPokeMons() {
        viewModel.fetchPokeMons().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("no connects PokeMons", it.message.toString())
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    pokeAdapter.submitList(it.data?.results)
                    Log.e("yes  connect", it.data?.results.toString())
                }
            }
        }
    }
}