package com.jrubiralta.marvelapp.data.response

import com.google.gson.annotations.SerializedName

data class ListItemResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("link") val link: String?
)