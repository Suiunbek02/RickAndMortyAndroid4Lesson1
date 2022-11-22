package com.example.rickandmortyandroid4lesson1.models.poke

import com.example.rickandmortyandroid4lesson1.base.BaseDiffUtil
import com.google.gson.annotations.SerializedName

data class PokeModel(

    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
) : BaseDiffUtil
