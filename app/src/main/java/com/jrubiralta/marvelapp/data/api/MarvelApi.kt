package com.jrubiralta.marvelapp.data.api

import com.jrubiralta.marvelapp.data.response.CharacterListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun getCharactersList(
        @Query("offset") offSet: Int,
        @Query("limit")limit: Int
    ): Response<CharacterListResponse>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacterDetail(@Path("characterId") characterId: Int): Response<CharacterListResponse>

}