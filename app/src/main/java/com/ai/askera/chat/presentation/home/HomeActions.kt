package com.ai.askera.chat.presentation.home

sealed class HomeActions {
    data class SendMessage(val message: String) : HomeActions()
}