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
import java.util.UUID

class ChatDataSourceImpl(
    private val db: AskeraDatabase
) : ChatDataSource {

    override suspend fun storeMessage(message: Message) {

        val conversationDao = db.conversationDao
        val messageDao = db.messagesDao

        val conversationId = message.conversationId

        if (!conversationId.isNullOrEmpty() && conversationDao.getConversationCount(conversationId) > 0) {
            messageDao.insertMessage(message = message.toMessageEntity())
        } else {

            val newConversation = Conversation(id = UUID.randomUUID().toString())
            conversationDao.insertConversation(newConversation.toConversationEntity())

            val updatedMessage = message.copy(
                conversationId = newConversation.id
            )
            messageDao.insertMessage(updatedMessage.toMessageEntity())
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
}