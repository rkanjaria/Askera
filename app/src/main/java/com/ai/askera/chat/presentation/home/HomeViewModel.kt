package com.ai.askera.chat.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.askera.chat.domain.ChatDataSource
import com.ai.askera.chat.domain.models.toConversationEntity
import com.ai.askera.chat.presentation.models.toConversationUi
import com.ai.askera.core.domain.util.prompts
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val chatDataSource: ChatDataSource
) : ViewModel() {

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

    private fun getChatHistory() {
        viewModelScope.launch {
            chatDataSource.getAllConversations().collect { conversations ->
                _state.update {
                    it.copy(
                        chatHistory = conversations.map { conversation ->
                            conversation.toConversationUi()
                        }
                    )
                }
            }
        }
    }
}