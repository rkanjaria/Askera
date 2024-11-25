package com.ai.askera.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ai.askera.chat.domain.entity.ConversationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(facts: List<ConversationEntity>)

    @Query("DELETE FROM conversations")
    suspend fun nukeConversations()

    @Query("SELECT * FROM conversations")
    fun getConversations(): Flow<List<ConversationEntity>>
}