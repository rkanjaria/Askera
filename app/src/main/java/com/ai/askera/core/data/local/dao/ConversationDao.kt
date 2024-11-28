package com.ai.askera.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ai.askera.chat.data.local.entity.ConversationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConversation(conversation: ConversationEntity)

    @Query("DELETE FROM conversations")
    suspend fun nukeConversations()

    @Query("SELECT * FROM conversations")
    fun getConversations(): Flow<List<ConversationEntity>>

    @Query("SELECT COUNT() FROM conversations WHERE id = :id")
    fun getConversationCount(id: String): Int
}