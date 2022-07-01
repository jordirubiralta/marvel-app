package com.jrubiralta.marvelapp.domain.repository

import androidx.paging.PagingData
import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getCharacterList(): Flow<PagingData<CharacterModel>>

    suspend fun getCharacterDetail(characterId: Int): NetworkResult<CharacterModel>

}