package com.ai.askera.chat.presentation.chat_screen


sealed interface ChatUiEvents {
    data object AnimateAndScrollToBottom : ChatUiEvents
    data object ScrollToBottom : ChatUiEvents
}