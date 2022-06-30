package com.jrubiralta.marvelapp.data.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val description: String?,
    val id: Int?,
    val name: String?,
    @SerializedName("thumbnail") val imageResponse: ImageResponse?,
)