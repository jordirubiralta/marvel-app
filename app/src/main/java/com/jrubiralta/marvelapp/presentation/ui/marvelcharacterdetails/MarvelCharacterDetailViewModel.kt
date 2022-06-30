package com.jrubiralta.marvelapp.presentation.ui.marvelcharacterdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.usecases.GetCharacterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelCharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailState(isLoading = true))
    val state: StateFlow<CharacterDetailState> = _state.asStateFlow()

    fun getCharacterDetails(characterId: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = getCharacterDetailUseCase.invoke(getCharacterDetailUseCase.Params(characterId))
            _state.update {
                when (result) {
                    is NetworkResult.Error -> {
                        it.copy(isLoading = false, errorMessage = result.message?.message)
                    }
                    is NetworkResult.Success -> {
                        it.copy(isLoading = false, characterDetails = result.data)
                    }
                }
            }
        }
    }

    data class CharacterDetailState(
        val isLoading: Boolean = false,
        val characterDetails: CharacterModel? = null,
        val errorMessage: String? = null
    )

}