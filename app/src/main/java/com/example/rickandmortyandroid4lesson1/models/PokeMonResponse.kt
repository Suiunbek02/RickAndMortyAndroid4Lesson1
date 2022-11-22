package com.example.rickandmortyandroid4lesson1.models

import com.google.gson.annotations.SerializedName

data class PokeMonResponse<T>(
    @SerializedName("count")
    val count: Int,

    @SerializedName("previous")
    val previous: String,

    @SerializedName("next")
    val next: String?,

    @SerializedName("results")
    val results: List<T>
)