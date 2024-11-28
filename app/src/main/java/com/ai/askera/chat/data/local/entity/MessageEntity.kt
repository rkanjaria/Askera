package com.ai.askera.chat.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "conversation_id")
    val conversationId: String? = null,
    @ColumnInfo(name = "message_from")
    val messageFrom: String? = null,
    @ColumnInfo(name = "message")
    val message: String? = null,
    @ColumnInfo(name = "created_at")
    val createdAt: Long? = System.currentTimeMillis(),
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long? = System.currentTimeMillis()
)