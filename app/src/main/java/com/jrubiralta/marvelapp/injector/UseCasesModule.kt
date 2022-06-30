package com.jrubiralta.marvelapp.injector

import com.jrubiralta.marvelapp.domain.repository.MarvelRepository
import com.jrubiralta.marvelapp.domain.usecases.GetCharacterDetailUseCase
import com.jrubiralta.marvelapp.domain.usecases.GetCharacterListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCasesModule {

    @Provides
    fun getCharacterListUseCaseProvider(repository: MarvelRepository) =
        GetCharacterListUseCase(repository)

    @Provides
    fun getCharacterDetailUseCaseProvider(repository: MarvelRepository) =
        GetCharacterDetailUseCase(repository)

}