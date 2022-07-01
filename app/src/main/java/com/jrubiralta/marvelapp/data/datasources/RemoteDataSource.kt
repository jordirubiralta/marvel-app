package com.jrubiralta.marvelapp.data.datasources

import com.jrubiralta.marvelapp.data.api.MarvelApi
import com.jrubiralta.marvelapp.data.response.CharacterListResponse
import retrofit2.Response

class RemoteDataSource(
    private val marvelApi: MarvelApi
) {

    suspend fun getCharacterDetail(characterId: Int): Response<CharacterListResponse> =
        marvelApi.getCharacterDetail(characterId)

}