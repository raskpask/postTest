package com.molin.posttest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molin.data.repository.INewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val postRepository: INewsRepository,
    ) : ViewModel() {
        private val _state = MutableStateFlow(MainUiState())
        val state: StateFlow<MainUiState> = _state.asStateFlow()

        init {
            viewModelScope.launch {
                postRepository.getNews().fold(
                    onSuccess = { news ->
                        _state.update { uiState -> uiState.copy(news = news.filter { it.id < 50 }) }
                    },
                    onFailure = {
                        // handle failure
                    },
                )
            }
        }
    }
