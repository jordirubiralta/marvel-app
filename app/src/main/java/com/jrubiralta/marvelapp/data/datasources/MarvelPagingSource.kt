package com.jrubiralta.marvelapp.data.datasources

import androidx.paging.PagingSource
import com.jrubiralta.marvelapp.data.api.MarvelApi
import com.jrubiralta.marvelapp.data.response.Mapper.toDomain
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import retrofit2.HttpException
import java.io.IOException

class MarvelPagingSource(
    private val marvelApi: MarvelApi
) : PagingSource<Int, CharacterModel>() {

    companion object {
        private const val STARTING_KEY = 0
        private const val NETWORK_PAGE_SIZE = 20
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val position = params.key ?: STARTING_KEY

        return try {
            val response = marvelApi.getCharactersList(position, params.loadSize)
            val repos = response.body()?.data?.charactersList?.map { it.toDomain() }?: emptyList()
            val nextKey = if (repos.isEmpty()) {
                null
            } else {
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = repos,
                prevKey = if (position == STARTING_KEY) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}