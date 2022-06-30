package com.jrubiralta.marvelapp.domain.usecases

import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.DataModel
import com.jrubiralta.marvelapp.domain.repository.MarvelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(private val repository: MarvelRepository) {

    suspend fun invoke(): NetworkResult<DataModel> = withContext(Dispatchers.IO) {
        repository.getCharacterList()
    }

}