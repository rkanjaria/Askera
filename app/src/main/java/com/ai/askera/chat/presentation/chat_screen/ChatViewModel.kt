package com.ai.askera.chat.presentation.chat_screen

import androidx.lifecycle.ViewModel
import com.ai.askera.chat.presentation.models.toMessageUi
import com.ai.askera.core.domain.util.dummyConversation
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

class ChatViewModel() : ViewModel() {

    private val _state = MutableStateFlow(ChatUiState())
    val state = _state.asStateFlow()

    private val _eventFlow = Channel<ChatUiEvents>()
    val eventFlow = _eventFlow.receiveAsFlow()

    init {
        getChatMessages()
    }

    private fun getChatMessages() {
        _state.update {
            it.copy(
                messages = dummyConversation.map { it.toMessageUi() }
            )
        }
    }
}