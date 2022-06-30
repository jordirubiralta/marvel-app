package com.jrubiralta.marvelapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ImageModel(
    val extension: String?,
    val path: String?
): Parcelable {


    fun isValidExtension() =
        extension == "jpg" || extension == "png"

}