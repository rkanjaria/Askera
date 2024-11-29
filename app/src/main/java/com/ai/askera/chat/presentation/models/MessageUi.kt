package com.ai.askera.chat.presentation.models

import com.ai.askera.chat.domain.models.Message
import com.ai.askera.core.presentation.util.toSimpleDate
import java.util.UUID


data class MessageUi(
    val id: String = UUID.randomUUID().toString(),
    val conversationId: String? = null,
    val messageFrom: String? = null,
    val message: String? = null,
    val createdAt: DisplayableDate? = null,
    val updatedAt: DisplayableDate? = null
)

data class DisplayableDate(
    val timeInMillis: Long,
    val formatted: String
)

fun Message.toMessageUi(): MessageUi {
    return MessageUi(
        id = id,
        conversationId = conversationId,
        message = message,
        messageFrom = messageFrom,
        createdAt = createdAt?.toDisplayableDate(),
        updatedAt = updatedAt?.toDisplayableDate()
    )
}

fun Long.toDisplayableDate(): DisplayableDate {
    return DisplayableDate(
        timeInMillis = this,
        formatted = this.toSimpleDate()
    )
}