package com.ai.askera.chat.presentation.chat_screen

import com.ai.askera.chat.presentation.models.MessageUi

data class ChatUiState(
    val isLoading: Boolean = false,
    val messages: List<MessageUi> = emptyList(),
)