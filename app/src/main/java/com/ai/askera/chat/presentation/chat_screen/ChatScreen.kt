package com.ai.askera.chat.presentation.chat_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.askera.chat.presentation.chat_screen.components.MessageCellAi
import com.ai.askera.chat.presentation.chat_screen.components.MessageCellUser
import com.ai.askera.chat.presentation.models.toMessageUi
import com.ai.askera.core.domain.util.MessageFrom
import com.ai.askera.core.domain.util.dummyConversation
import com.ai.askera.core.presentation.util.ObserveAsEvents
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.size
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun ChatScreen(
    navController: NavController,
    state: ChatUiState,
    uiEvents: Flow<ChatUiEvents>,
) {

    val messages = state.messages

    ObserveAsEvents(flow = uiEvents) { event ->

    }

    Box(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(

                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                start = MaterialTheme.size.extraLarge,
                end = MaterialTheme.size.extraLarge,
                top = MaterialTheme.size.extraLarge,
                bottom = MaterialTheme.size.extraLarge.plus(
                    WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
                )
            ),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.size.extraLarge)
        ) {

            items(messages) { message ->

                val isMessageFromUser = message.messageFrom == MessageFrom.USER

                if (isMessageFromUser) {
                    MessageCellUser(message = message)
                } else {
                    MessageCellAi(message = message)
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun ChatScreenPreview() {
    AskeraTheme {

        ChatScreen(
            navController = rememberNavController(),
            uiEvents = emptyFlow(),
            state = ChatUiState(
                messages = dummyConversation.map { it.toMessageUi() }
            )
        )
    }
}
