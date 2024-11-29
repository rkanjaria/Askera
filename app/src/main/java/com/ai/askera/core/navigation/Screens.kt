package com.ai.askera.core.navigation

import kotlinx.serialization.Serializable


@Serializable
data object SplashScreen

@Serializable
data class WalkthroughScreen(
    val name: String? = null
)

@Serializable
data object HomeScreen

@Serializable
data class ChatScreen(
    val prompt: String?,
    val conversationId: String? = null
)