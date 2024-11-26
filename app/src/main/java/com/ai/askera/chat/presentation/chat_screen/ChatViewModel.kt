package com.ai.askera.chat.presentation.chat_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.askera.BuildConfig
import com.ai.askera.chat.presentation.models.MessageUi
import com.ai.askera.core.domain.util.MessageFrom
import com.ai.askera.core.domain.util.SystemInstruction
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.BlockThreshold
import com.google.ai.client.generativeai.type.HarmCategory
import com.google.ai.client.generativeai.type.SafetySetting
import com.google.ai.client.generativeai.type.content
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatViewModel() : ViewModel() {

    private val _state = MutableStateFlow(ChatUiState())
    val state = _state.asStateFlow()

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

    val chat = model.startChat(history = emptyList())

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

                val response = chat.sendMessage(message)

                response.let { chatResponse ->

                    val messageFromModel = chatResponse.text?.trim()
                    if (!messageFromModel.isNullOrEmpty()) {
                        addMessageToList(
                            message = messageFromModel,
                            from = MessageFrom.AI
                        )
                    }
                }
            }
        }
    }

    private fun addMessageToList(message: String, from: String) {

        val chatMessage = MessageUi(
            message = message,
            messageFrom = from
        )

        val updatedMessageList = _state.value.messages.plus(chatMessage)
        _state.update { it.copy(messages = updatedMessageList) }
    }
}