package com.ai.askera.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ai.askera.chat.domain.entity.MessageEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MessagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(facts: List<MessageEntity>)

    @Query("DELETE FROM messages")
    suspend fun nukeMessages()

    @Query("SELECT * FROM messages WHERE conversation_id = :conversationId")
    fun getMessagesForConversation(conversationId: String): Flow<List<MessageEntity>>
}