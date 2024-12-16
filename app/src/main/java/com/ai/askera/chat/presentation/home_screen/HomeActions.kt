package com.ai.askera.chat.presentation.home_screen

sealed interface HomeActions {
    data class SendMessage(val message: String) : HomeActions
}