package com.ai.askera.chat.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.askera.chat.domain.ChatDataSource
import com.ai.askera.chat.presentation.models.toConversationUi
import com.ai.askera.core.domain.util.prompts
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class HomeViewModel(
    private val chatDataSource: ChatDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState(prompts = prompts))
    val state = _state.onStart {
        getChatHistory()
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = HomeUiState(prompts = prompts)
        )

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
                        chatHistory = conversations.take(3).map { conversation ->
                            conversation.toConversationUi()
                        }
                    )
                }
            }
        }
    }
}