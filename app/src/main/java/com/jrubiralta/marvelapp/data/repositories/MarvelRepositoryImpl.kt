package com.jrubiralta.marvelapp.data.repositories

import com.jrubiralta.marvelapp.data.datasources.RemoteDataSource
import com.jrubiralta.marvelapp.data.response.Mapper.toDomain
import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.model.DataModel
import com.jrubiralta.marvelapp.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MarvelRepository {

    override suspend fun getCharacterList(): NetworkResult<DataModel> {
        return try {
            val response = remoteDataSource.getCharacterList()
            if (response.isSuccessful) {
                response.body()?.data?.let {
                    return@let NetworkResult.Success(it.toDomain())
                } ?: run {
                    NetworkResult.Error(Exception("The body is empty"))
                }
            } else {
                NetworkResult.Error(Exception("Response not successful"))
            }
        } catch (e: Exception) {
            NetworkResult.Error(Exception("Network error"))
        }
    }

    override suspend fun getCharacterDetail(characterId: Int): NetworkResult<CharacterModel> {
        return try {
            val response = remoteDataSource.getCharacterDetail(characterId)
            if (response.isSuccessful) {
                response.body()?.data?.charactersList?.firstOrNull()?.let {
                    return@let NetworkResult.Success(it.toDomain())
                } ?: run {
                    NetworkResult.Error(Exception("The body is empty"))
                }
            } else {
                NetworkResult.Error(Exception("Response not successful"))
            }
        } catch (e: Exception) {
            NetworkResult.Error(Exception("Network error"))
        }
    }

}
