package com.jrubiralta.marvelapp.data.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    val count: Int?,
    val limit: Int?,
    val offset: Int?,
    @SerializedName("results") val charactersList: List<CharacterResponse>?,
    val total: Int?
)