package com.ai.askera.chat.presentation.chat_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.chat.data.local.entity.MessageEntity
import com.ai.askera.chat.domain.models.Message
import com.ai.askera.chat.presentation.models.MessageUi
import com.ai.askera.chat.presentation.models.toMessageUi
import com.ai.askera.core.domain.util.MessageFrom
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size

@Composable
fun MessageCellUser(
    modifier: Modifier = Modifier,
    message: MessageUi
) {

    val messageShape = RoundedCornerShape(
        topStart = MaterialTheme.size.megaLarge,
        topEnd = MaterialTheme.size.megaLarge,
        bottomStart = MaterialTheme.size.megaLarge,
        bottomEnd = MaterialTheme.size.minor,
    )

    val isMessageFromUser = message.messageFrom == MessageFrom.USER

    val color = MaterialTheme.colorScheme.primary

    Box(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (isMessageFromUser) {
                    Modifier.padding(start = MaterialTheme.size.megaLarge)
                } else Modifier
            ),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            modifier = Modifier
                .wrapContentWidth()
                .clip(messageShape)
                .background(color)
                .padding(all = MaterialTheme.size.extraLarge),
            text = message.message ?: "",
            style = MaterialTheme.body.medium.copy(
                color = Color.White,
            )
        )
    }
}


@PreviewLightDark
@Composable
private fun MessageCellUserPreview() {
    AskeraTheme {
        MessageCellUser(message = messageUser)
    }
}

internal val messageUser = Message(
    id = "",
    message = "Show me latest Notion inbox with some long due task that weren't taken up in last sprint",
    messageFrom = MessageFrom.USER,
    createdAt = System.currentTimeMillis(),
    updatedAt = System.currentTimeMillis()
).toMessageUi()