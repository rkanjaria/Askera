package com.ai.askera.chat.presentation.mappers

import com.ai.askera.chat.domain.models.Message
import com.ai.askera.chat.presentation.models.MessageUi

fun MessageUi.toMessage(): Message {

    return Message(
        id = id,
        conversationId = conversationId,
        messageFrom = messageFrom,
        message = message
    )
}