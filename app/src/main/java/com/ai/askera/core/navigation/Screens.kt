package com.ai.askera.core.navigation

import kotlinx.serialization.Serializable


@Serializable
data object SplashScreen

@Serializable
data object HomeScreen

@Serializable
data class ChatScreen(
    val prompt: String? = null,
    val conversationId: String? = null
)

@Serializable
data object ChatHistoryScreen