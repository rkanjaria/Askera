package com.ai.askera.chat.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "conversations")
data class ConversationEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "created_at")
    val createdAt: Long? = System.currentTimeMillis(),
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long? = System.currentTimeMillis()
)
