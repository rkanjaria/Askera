package com.ai.askera.chat.presentation.history_screen

import com.ai.askera.chat.presentation.models.ConversationUi

data class ChatHistoryUiState(
    val isLoading: Boolean = false,
    val chatHistory: Map<String, List<ConversationUi>> = emptyMap(),
)