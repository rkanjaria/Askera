package com.ai.askera.chat.presentation.chat_screen

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.askera.R
import com.ai.askera.chat.presentation.chat_screen.components.MessageCellAi
import com.ai.askera.chat.presentation.chat_screen.components.MessageCellGenerating
import com.ai.askera.chat.presentation.chat_screen.components.MessageCellUser
import com.ai.askera.chat.presentation.components.ChatBar
import com.ai.askera.chat.presentation.models.GeneratingUi
import com.ai.askera.chat.presentation.models.MessageUi
import com.ai.askera.chat.presentation.models.toMessageUi
import com.ai.askera.core.domain.util.MessageFrom
import com.ai.askera.core.domain.util.dummyConversation
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.size
import com.ai.askera.ui.theme.title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
    state: ChatUiState,
    onAction: (ChatActions) -> Unit
) {

    val listState = rememberLazyListState()
    val messages = state.messages
    val shouldPerformSmoothScroll = state.smoothScrollToBottom
    val isGenerating = state.isGenerating

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {

            if (shouldPerformSmoothScroll) {
                listState.animateScrollToItem(messages.lastIndex)
            } else {
                listState.scrollToItem(messages.lastIndex)
            }
        }
    }

    Box(
        modifier = Modifier
            .statusBarsPadding()
            .imePadding()
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.background,
                    )
                )
            )
    ) {

        LazyColumn(
            modifier = Modifier.padding(top = MaterialTheme.size.dp80),
            state = listState,
            contentPadding = PaddingValues(
                start = MaterialTheme.size.extraLarge,
                end = MaterialTheme.size.extraLarge,
                top = MaterialTheme.size.extraLarge,
                bottom = MaterialTheme.size.dp100.plus(
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

            if (isGenerating) {
                item {
                    MessageCellGenerating(
                        modifier = Modifier
                            .size(MaterialTheme.size.dp70)
                            .offset(x = MaterialTheme.size.dp8.times(-1))
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.size.dp100)
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color.Transparent,
                            0.5f to MaterialTheme.colorScheme.background,
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )

        ChatBar(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    start = MaterialTheme.size.extraLarge,
                    end = MaterialTheme.size.extraLarge,
                    bottom = MaterialTheme.size.extraSmall
                )
                .align(Alignment.BottomCenter),

            onSendButtonClicked = { userMessage ->
                onAction.invoke(
                    ChatActions.SendMessage(
                        message = userMessage
                    )
                )
            }
        )
    }

    CenterAlignedTopAppBar(
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            scrolledContainerColor = MaterialTheme.colorScheme.surface,
        ),
        windowInsets = WindowInsets(
            left = MaterialTheme.size.medium,
            right = MaterialTheme.size.medium,
            bottom = MaterialTheme.size.default,
            top = MaterialTheme.size.default.plus(
                WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
            ),
        ),
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.surfaceBright)
                    .size(MaterialTheme.size.dp40),
                onClick = {
                    navController.navigateUp()
                }) {

                Icon(
                    modifier = Modifier.padding(end = MaterialTheme.size.dp2),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_backward),
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        title = {
            Text(
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.size.extraLarge),
                text = "Askera",
                style = MaterialTheme.title.extraLarge.copy(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary,
                        )
                    ),
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun ChatScreenPreview() {
    AskeraTheme {

        ChatScreen(
            navController = rememberNavController(),
            state = ChatUiState(
                messages = dummyConversation.take(2).map { it.toMessageUi() },
                isGenerating = true
            ),
            onAction = {}
        )
    }
}
