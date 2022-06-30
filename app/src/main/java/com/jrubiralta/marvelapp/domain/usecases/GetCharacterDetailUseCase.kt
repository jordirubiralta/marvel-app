package com.jrubiralta.marvelapp.domain.usecases

import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.repository.MarvelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(private val repository: MarvelRepository) {

    suspend fun invoke(params: Params): NetworkResult<CharacterModel> = withContext(Dispatchers.IO) {
        repository.getCharacterDetail(params.characterId)
    }
    inner class Params(val characterId: Int)
}