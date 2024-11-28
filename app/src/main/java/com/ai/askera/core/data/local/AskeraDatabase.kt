package com.ai.askera.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ai.askera.chat.data.local.entity.ConversationEntity
import com.ai.askera.chat.data.local.entity.MessageEntity
import com.ai.askera.core.data.local.dao.ConversationDao
import com.ai.askera.core.data.local.dao.MessagesDao

@Database(
    entities = [
        ConversationEntity::class,
        MessageEntity::class
    ],
    version = 1
)
abstract class AskeraDatabase : RoomDatabase() {

    abstract val conversationDao: ConversationDao
    abstract val messagesDao: MessagesDao
}