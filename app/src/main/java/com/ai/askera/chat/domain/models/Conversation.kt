package com.ai.askera.chat.domain.models

import com.ai.askera.chat.data.local.entity.ConversationEntity
import java.util.UUID


data class Conversation(
    val id: String = UUID.randomUUID().toString(),
    val title: String? = null,
    val createdAt: Long? = System.currentTimeMillis(),
    val updatedAt: Long? = System.currentTimeMillis()
)


fun Conversation.toConversationEntity(): ConversationEntity {
    return ConversationEntity(
        id = id,
        title = title,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
