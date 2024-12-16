package com.ai.askera.chat.presentation.models

import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.domain.models.Message
import com.ai.askera.core.presentation.util.toSimpleDate
import java.util.UUID

data class ConversationUi(
    val id: String = UUID.randomUUID().toString(),
    val createdAt: DisplayableDate?,
    val updatedAt: DisplayableDate?,
    val title: String
)


fun Conversation.toConversationUi(): ConversationUi {
    return ConversationUi(
        id = id,
        createdAt = createdAt?.toDisplayableDate(),
        updatedAt = updatedAt?.toDisplayableDate(),
        title = title.orEmpty()
    )
}


