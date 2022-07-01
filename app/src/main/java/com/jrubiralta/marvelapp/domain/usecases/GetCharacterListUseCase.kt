package com.jrubiralta.marvelapp.domain.usecases

import androidx.paging.PagingData
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.repository.MarvelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(private val repository: MarvelRepository) {

    fun invoke(): Flow<PagingData<CharacterModel>> = repository.getCharacterList()
}