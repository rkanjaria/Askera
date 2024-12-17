package com.ai.askera.chat.presentation.chat_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.chat.domain.models.Message
import com.ai.askera.chat.presentation.models.MessageUi
import com.ai.askera.chat.presentation.models.toMessageUi
import com.ai.askera.core.domain.util.MessageFrom
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size


@Composable
fun MessageCellAi(
    modifier: Modifier = Modifier,
    message: MessageUi
) {

    val messageShape = RoundedCornerShape(
        topStart = MaterialTheme.size.minor,
        topEnd = MaterialTheme.size.megaLarge,
        bottomStart = MaterialTheme.size.megaLarge,
        bottomEnd = MaterialTheme.size.megaLarge,
    )

    val color = MaterialTheme.colorScheme.surfaceDim
    val textColor = MaterialTheme.colorScheme.onSurface

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(messageShape)
            .background(color)
            .padding(all = MaterialTheme.size.extraLarge)
    ) {

        Text(
            modifier = Modifier.align(Alignment.CenterStart),
            text = message.message ?: "",
            style = MaterialTheme.body.medium.copy(
                color = textColor,
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun MessageCellAiPreview() {
    AskeraTheme {
        MessageCellAi(message = messageAi)
    }
}

internal val messageAi = Message(
    id = "",
    message = "Hello! I’m Askera, your AI companion. What can I help you discover today?",
    messageFrom = MessageFrom.MODEL,
    createdAt = System.currentTimeMillis(),
    updatedAt = System.currentTimeMillis()
).toMessageUi()