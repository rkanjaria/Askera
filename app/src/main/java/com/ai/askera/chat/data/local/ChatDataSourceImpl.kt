package com.ai.askera.chat.data.local

import com.ai.askera.chat.data.mappers.toConversation
import com.ai.askera.chat.data.mappers.toMessage
import com.ai.askera.chat.domain.ChatDataSource
import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.domain.models.Message
import com.ai.askera.chat.domain.models.toConversationEntity
import com.ai.askera.chat.domain.models.toMessageEntity
import com.ai.askera.core.data.local.AskeraDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChatDataSourceImpl(
    private val db: AskeraDatabase
) : ChatDataSource {

    override suspend fun storeMessage(message: Message) {

        if (message.id.isNotEmpty() && message.conversationId.isNullOrEmpty().not()) {
            val messageDao = db.messagesDao
            messageDao.insertMessage(message = message.toMessageEntity())
        }
    }

    override suspend fun storeConversation(conversation: Conversation) {
        if (conversation.id.isNotEmpty()) {
            db.conversationDao.insertConversation(conversation.toConversationEntity())
        }
    }

    override suspend fun getAllConversations(): Flow<List<Conversation>> {
        return db.conversationDao.getConversations().map {
            it.map { entity -> entity.toConversation() }
        }
    }

    override suspend fun getAllMessagesForConversation(conversationId: String): Flow<List<Message>> {
        return db.messagesDao.getMessagesForConversation(conversationId).map {
            it.map { entity -> entity.toMessage() }
        }
    }

    override suspend fun getConversationCount(conversationId: String): Int {
        return db.conversationDao.getConversationCount(conversationId)
    }
}