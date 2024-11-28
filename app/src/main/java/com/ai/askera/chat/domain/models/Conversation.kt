package com.ai.askera.chat.domain.models

import com.ai.askera.chat.data.local.entity.ConversationEntity
import java.util.UUID


data class Conversation(
    val id: String = UUID.randomUUID().toString(),
    val createdAt: String? = System.currentTimeMillis().toString(),
    val updatedAt: String? = System.currentTimeMillis().toString()
)


fun Conversation.toConversationEntity(): ConversationEntity {
    return ConversationEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
