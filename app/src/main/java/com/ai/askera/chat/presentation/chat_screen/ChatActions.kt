package com.ai.askera.chat.presentation.chat_screen

sealed class ChatActions {
    data class SendMessage(val message: String) : ChatActions()
}