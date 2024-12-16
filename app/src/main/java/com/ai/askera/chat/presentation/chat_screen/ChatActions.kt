package com.ai.askera.chat.presentation.chat_screen

sealed interface ChatActions {
    data class SendMessage(val message: String) : ChatActions
}