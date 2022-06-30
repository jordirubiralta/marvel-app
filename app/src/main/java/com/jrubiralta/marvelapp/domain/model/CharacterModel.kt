package com.jrubiralta.marvelapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CharacterModel(
    val description: String?,
    val id: Int?,
    val name: String?,
    val image: ImageModel?,
): Parcelable