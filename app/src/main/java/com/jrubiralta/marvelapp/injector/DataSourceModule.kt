package com.jrubiralta.marvelapp.injector

import com.jrubiralta.marvelapp.data.api.MarvelApi
import com.jrubiralta.marvelapp.data.datasources.MarvelPagingSource
import com.jrubiralta.marvelapp.data.datasources.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun remoteDataSourceProvider(marvelApi: MarvelApi) = RemoteDataSource(marvelApi)

    @Provides
    fun pagingSourceProvider(marvelApi: MarvelApi) = MarvelPagingSource(marvelApi)

}