package com.ai.askera.core.domain.util

import com.ai.askera.chat.domain.entity.MessageEntity

object MessageFrom {
    const val USER = "user"
    const val AI = "ai"
}

val dummyConversation = listOf(
    MessageEntity(
        id = "1",
        message = "Hello! I’m Askera, your AI companion. What can I help you discover today?",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "2",
        message = "Hi Askera! Can you recommend a good movie to watch?",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "3",
        message = "Sure! Do you have a specific genre in mind, or are you open to anything?",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "4",
        message = "I’d like something adventurous and family-friendly.",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "5",
        message = "How about 'The Secret Life' of Walter Mitty? It’s adventurous, uplifting, and perfect for all ages!",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "6",
        message = "That sounds great! Where can I watch it?",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "7",
        message = "You can find it on most streaming platforms like Hulu or Amazon Prime. Want me to look up exact availability for you?",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "8",
        message = "Yes, please!",
        messageFrom = MessageFrom.USER,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    ),
    MessageEntity(
        id = "9",
        message = "Got it! The movie is currently streaming on Hulu. Enjoy the adventure!",
        messageFrom = MessageFrom.AI,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    )
)