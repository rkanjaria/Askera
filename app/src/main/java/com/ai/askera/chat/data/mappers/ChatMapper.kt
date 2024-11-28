package com.ai.askera.chat.data.mappers

import com.ai.askera.chat.data.local.entity.ConversationEntity
import com.ai.askera.chat.data.local.entity.MessageEntity
import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.domain.models.Message

fun MessageEntity.toMessage(): Message {
    return Message(
        id = id,
        conversationId = conversationId,
        message = message,
        messageFrom = messageFrom,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun ConversationEntity.toConversation(): Conversation {
    return Conversation(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}


