package com.jrubiralta.marvelapp.domain.repository

import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.model.DataModel

interface MarvelRepository {

    suspend fun getCharacterList(): NetworkResult<DataModel>

    suspend fun getCharacterDetail(characterId: Int): NetworkResult<CharacterModel>

}