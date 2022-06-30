package com.jrubiralta.marvelapp.data.response

import com.google.gson.annotations.SerializedName

data class ItemDetailsResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("imagePath") val imagePath: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("author") val author: String?
)