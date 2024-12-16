package com.ai.askera.chat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.R
import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.presentation.models.ConversationUi
import com.ai.askera.chat.presentation.models.toConversationUi
import com.ai.askera.core.domain.util.prompts
import com.ai.askera.core.presentation.util.clickableWithoutRipple
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size


@Composable
fun ChatHistoryCard(
    modifier: Modifier = Modifier,
    conversation: ConversationUi,
    onChatHistoryClicked: (ConversationUi) -> Unit = {}
) {

    val chatHistoryCardShape = RoundedCornerShape(MaterialTheme.size.dp18)
    val backgroundColor = MaterialTheme.colorScheme.surfaceDim

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .clip(chatHistoryCardShape)
            .background(color = backgroundColor)
            .padding(all = MaterialTheme.size.extraLarge)
            .clickableWithoutRipple { onChatHistoryClicked(conversation) },

        ) {

        Text(
            modifier = Modifier.fillMaxWidth()
                .drawWithContent {
                    drawContent()
                    drawRect(
                        brush = Brush.horizontalGradient(
                            colorStops = arrayOf(
                                0.7f to Color.Transparent,
                                0.9f to backgroundColor
                            )
                        )
                    )
                },
            text = conversation.title,
            style = MaterialTheme.body.medium.copy(
                color = MaterialTheme.colorScheme.onSurface,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_forward),
            contentDescription = "Send",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@PreviewLightDark
@Composable
private fun ChatHistoryCardPreview() {
    AskeraTheme {
        ChatHistoryCard(
            modifier = Modifier.fillMaxWidth(),
            conversation = conversationUi,
        )
    }
}

internal val conversationUi = Conversation(
    title = prompts.first().prompt
).toConversationUi()