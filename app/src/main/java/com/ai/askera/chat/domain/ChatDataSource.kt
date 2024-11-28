package com.ai.askera.chat.domain

import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.domain.models.Message
import kotlinx.coroutines.flow.Flow

interface ChatDataSource {

    suspend fun storeMessage(message: Message)
    suspend fun getAllConversations(): Flow<List<Conversation>>
    suspend fun getAllMessagesForConversation(
        conversationId: String
    ): Flow<List<Message>>
}