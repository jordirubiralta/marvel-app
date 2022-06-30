package com.jrubiralta.marvelapp.presentation.ui.marvellist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrubiralta.marvelapp.domain.commons.NetworkResult
import com.jrubiralta.marvelapp.domain.model.CharacterModel
import com.jrubiralta.marvelapp.domain.usecases.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelListViewModel @Inject constructor(private val getCharacterListUseCase: GetCharacterListUseCase) : ViewModel() {

    private val _event = MutableSharedFlow<Event>()
    val event: SharedFlow<Event> = _event.asSharedFlow()

    private val _state = MutableStateFlow(MarvelListState(isLoading = true))
    val state: StateFlow<MarvelListState> = _state.asStateFlow()

    fun getCharacterList() {
        viewModelScope.launch(Dispatchers.Main) {
            _state.update { it.copy(isLoading = true) }
            val result = getCharacterListUseCase.invoke()
            _state.update {
                when (result) {
                    is NetworkResult.Error -> {
                        it.copy(isLoading = false, errorMessage = result.message?.message)
                    }
                    is NetworkResult.Success -> {
                        it.copy(isLoading = false, characterList = result.data.charactersList)
                    }
                }
            }
        }
    }

    fun navigateToCharacterDetails(model: CharacterModel) {
        viewModelScope.launch {
            _event.emit(
                Event.ProceedToCharacterDetails(model)
            )
        }
    }

    data class MarvelListState(
        val isLoading: Boolean = false,
        val characterList: List<CharacterModel> = emptyList(),
        val errorMessage: String? = null
    )

    sealed class Event {
        data class ProceedToCharacterDetails(val model: CharacterModel) : Event()
    }
}