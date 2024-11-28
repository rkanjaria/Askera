package com.ai.askera.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ai.askera.chat.data.local.entity.MessageEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MessagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(messages: List<MessageEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: MessageEntity)

    @Query("DELETE FROM messages")
    suspend fun nukeMessages()

    @Query("SELECT * FROM messages WHERE conversation_id = :conversationId")
    fun getMessagesForConversation(conversationId: String): Flow<List<MessageEntity>>
}