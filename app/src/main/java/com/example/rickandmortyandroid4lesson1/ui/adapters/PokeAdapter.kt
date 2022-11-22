package com.example.rickandmortyandroid4lesson1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyandroid4lesson1.base.BaseDiffUtilItemCallback
import com.example.rickandmortyandroid4lesson1.databinding.ItemPokemoneBinding
import com.example.rickandmortyandroid4lesson1.models.poke.PokeModel

class PokeAdapter : ListAdapter<PokeModel, PokeAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    class ViewHolder(private val binding: ItemPokemoneBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PokeModel?) {
            binding.itemPokeMonText.text = item?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPokemoneBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))

    }
}