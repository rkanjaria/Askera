package com.ai.askera.chat.presentation.chat_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.ai.askera.BuildConfig
import com.ai.askera.chat.domain.ChatDataSource
import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.domain.models.Message
import com.ai.askera.chat.presentation.models.toMessageUi
import com.ai.askera.core.domain.util.MessageFrom
import com.ai.askera.core.domain.util.SystemInstruction
import com.ai.askera.core.domain.util.errorResponses
import com.ai.askera.core.navigation.ChatScreen
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.BlockThreshold
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.HarmCategory
import com.google.ai.client.generativeai.type.SafetySetting
import com.google.ai.client.generativeai.type.content
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.time.Duration.Companion.seconds

class ChatViewModel(
    savedStateHandle: SavedStateHandle,
    private val chatDataSource: ChatDataSource
) : ViewModel() {

    private val data = savedStateHandle.toRoute<ChatScreen>()
    private val prompt = data.prompt
    private val conversationId = data.conversationId ?: UUID.randomUUID().toString()

    private val config = generationConfig { temperature = 0.7f }

    private val model = GenerativeModel(
        modelName = "gemini-1.5-pro-latest",
        apiKey = BuildConfig.API_KEY,
        generationConfig = config,
        safetySettings = listOf(
            SafetySetting(HarmCategory.HARASSMENT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.HATE_SPEECH, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.SEXUALLY_EXPLICIT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.DANGEROUS_CONTENT, BlockThreshold.MEDIUM_AND_ABOVE)
        ),
        systemInstruction = content { text(SystemInstruction) }
    )

    var chat: Chat? = null

    private val _state = MutableStateFlow(ChatUiState())
    val state = _state
        .onStart {

            // When message is null or empty, user has landed to chat screen via history.
            // When user clicks on prompt or types in the message message will not be empty

            val message = prompt

            if (!message.isNullOrEmpty()) {
                createConversationIfNotExists(conversationTitle = message)
                chat = model.startChat()
                sendMessage(message = message)
            } else {
                // User has came via chat history. Fetch the old conversation
                getMessagesFromConversation(conversationId)
                chat = model.startChat(getChatHistory())
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = ChatUiState()
        )

    fun onAction(action: ChatActions) {
        when (action) {
            is ChatActions.SendMessage -> {
                val message = action.message
                sendMessage(message)
            }
        }
    }

    private fun sendMessage(message: String) {

        viewModelScope.launch {

            if (message.isNotEmpty()) {

                addMessageToList(
                    message = message,
                    from = MessageFrom.USER
                )

                try {

                    val response = chat?.sendMessage(message)

                    response.let { chatResponse ->

                        val messageFromModel = chatResponse?.text?.trim()

                        if (!messageFromModel.isNullOrEmpty()) {

                            addMessageToList(
                                message = messageFromModel,
                                from = MessageFrom.MODEL
                            )
                        }
                    }

                } catch (e: Exception) {

                    e.printStackTrace()

                    addMessageToList(
                        message = errorResponses.random(),
                        from = MessageFrom.MODEL
                    )
                }
            }
        }
    }

    private fun addMessageToList(message: String, from: String) {

        val chatMessage = Message(
            message = message,
            messageFrom = from,
            conversationId = conversationId
        )

        val updatedMessageList = _state.value.messages.plus(chatMessage.toMessageUi())
        _state.update {
            it.copy(
                messages = updatedMessageList,
                smoothScrollToBottom = true
            )
        }

        // Store message in db
        storeMessage(chatMessage)
    }

    private suspend fun createConversationIfNotExists(conversationTitle: String) {

        val doesConversationExists = chatDataSource.getConversationCount(conversationId) > 0
        if (doesConversationExists) return

        val newConversation = Conversation(
            id = conversationId,
            title = conversationTitle
        )

        chatDataSource.storeConversation(newConversation)
    }

    private fun storeMessage(message: Message) {
        viewModelScope.launch {
            chatDataSource.storeMessage(message)
        }
    }

    private suspend fun getMessagesFromConversation(conversationId: String) {

        val messages = chatDataSource.getAllMessagesForConversation(conversationId)
            .firstOrNull()
            .orEmpty()

        _state.update {
            it.copy(
                messages = messages.map { messageModel -> messageModel.toMessageUi() }
            )
        }
    }

    private fun getChatHistory(): List<Content> {

        val messages = _state.value.messages.filter { it.message.isNullOrEmpty().not() }

        val content = messages.map { message ->
            content(role = message.messageFrom) { text(message.message.orEmpty()) }
        }

        return content
    }
}