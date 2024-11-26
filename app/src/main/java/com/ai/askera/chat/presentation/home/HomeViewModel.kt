package com.ai.askera.chat.presentation.home

import androidx.lifecycle.ViewModel
import com.ai.askera.core.domain.util.prompts
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class HomeViewModel() : ViewModel() {

    private val _state = MutableStateFlow(
        HomeUiState(prompts = prompts)
    )
    val state = _state.asStateFlow()

    private val _eventFlow = Channel<HomeActions>()
    val eventFlow = _eventFlow.receiveAsFlow()

    fun onAction(action: HomeActions) {
        when (action) {
            is HomeActions.SendMessage -> {

            }
        }
    }
}