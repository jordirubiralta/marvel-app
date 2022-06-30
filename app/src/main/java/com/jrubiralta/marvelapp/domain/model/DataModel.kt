package com.jrubiralta.marvelapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class DataModel(
    val count: Int,
    val limit: Int?,
    val offset: Int?,
    val charactersList: List<CharacterModel>,
    val total: Int
): Parcelable