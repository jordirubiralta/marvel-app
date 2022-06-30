package com.jrubiralta.marvelapp.data.response

import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.model.DataModel
import com.jrubiralta.marvelapp.domain.model.ImageModel

object Mapper {

    fun DataResponse.toDomain() = DataModel(
        count = this.count ?: 0,
        limit = this.limit,
        offset = this.offset,
        charactersList = this.charactersList?.map { it.toDomain() } ?: emptyList(),
        total = this.total ?: 0
    )

    fun CharacterResponse.toDomain() = CharacterModel(
        description = this.description,
        id = this.id,
        name = this.name,
        image = this.imageResponse?.toDomain()
    )

    private fun ImageResponse.toDomain() = ImageModel(
        extension = this.extension,
        path = this.path
    )
}