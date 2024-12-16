package com.ai.askera.chat.presentation.history_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.askera.chat.domain.ChatDataSource
import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.presentation.models.ConversationUi
import com.ai.askera.chat.presentation.models.toConversationUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.Locale
import kotlin.time.Duration.Companion.seconds

class ChatHistoryViewModel(
    private val chatDataSource: ChatDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(ChatHistoryUiState())
    val state = _state.onStart {
        getChatHistory()
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = ChatHistoryUiState()
        )

    private fun getChatHistory() {
        viewModelScope.launch {
            chatDataSource.getAllConversations().collect { conversations ->
                groupConversations(conversations)
            }
        }
    }

    private fun groupConversations(conversations: List<Conversation>) {

        val now = LocalDate.now()
        val today = mutableListOf<ConversationUi>()
        val last30Days = mutableListOf<ConversationUi>()
        val older = mutableMapOf<String, MutableList<ConversationUi>>()

        conversations.forEach { conversation ->

            val conversationUi = conversation.toConversationUi()

            val date = Instant.ofEpochMilli(conversation.createdAt ?: 0L)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()

            when {
                date == now -> today.add(conversationUi) // Conversations from today
                date.isAfter(now.minusDays(30)) -> last30Days.add(conversationUi) // Last 30 days
                else -> {
                    // Group older conversations by month and year
                    val monthYear = date.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) +
                            " " + date.year
                    older.getOrPut(monthYear) { mutableListOf() }.add(conversationUi)
                }
            }
        }

        // Combine into a single map
        val groupedConversations = mutableMapOf<String, List<ConversationUi>>()
        if (today.isNotEmpty()) groupedConversations["Today"] = today
        if (last30Days.isNotEmpty()) groupedConversations["Last 30 Days"] = last30Days
        groupedConversations.putAll(older)

        _state.update { it.copy(chatHistory = groupedConversations) }
    }
}