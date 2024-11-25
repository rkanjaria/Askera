package com.ai.askera.chat.presentation.models

import java.util.UUID

data class ConversationUi(
    val id: String = UUID.randomUUID().toString(),
    val createdAt: DisplayableDate?,
    val updatedAt: DisplayableDate?
)

