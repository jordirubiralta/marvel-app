package com.jrubiralta.marvelapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jrubiralta.marvelapp.data.datasources.MarvelPagingSource
import com.jrubiralta.marvelapp.data.datasources.RemoteDataSource
import com.jrubiralta.marvelapp.data.response.CharacterResponse
import com.jrubiralta.marvelapp.data.response.Mapper.toDomain
import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val pagingSource: MarvelPagingSource
) : MarvelRepository {

    companion object {
        private const val NETWORK_PAGE_SIZE = 30
    }

    override fun getCharacterList(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { pagingSource }
        ).flow
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
