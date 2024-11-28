package com.ai.askera.chat.domain.models

import com.ai.askera.chat.data.local.entity.MessageEntity
import java.util.UUID


data class Message(
    val id: String = UUID.randomUUID().toString(),
    val conversationId: String? = null,
    val messageFrom: String? = null,
    val message: String? = null,
    val createdAt: Long? = System.currentTimeMillis(),
    val updatedAt: Long? = System.currentTimeMillis()
)

fun Message.toMessageEntity(): MessageEntity {
    return MessageEntity(
        id = id,
        conversationId = conversationId,
        message = message,
        messageFrom = messageFrom,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
