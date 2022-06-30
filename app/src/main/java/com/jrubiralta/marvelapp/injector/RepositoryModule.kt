package com.jrubiralta.marvelapp.injector

import com.jrubiralta.marvelapp.data.repositories.MarvelRepositoryImpl
import com.jrubiralta.marvelapp.domain.repository.MarvelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMarvelRepository(
        repositoryImpl: MarvelRepositoryImpl
    ): MarvelRepository
}