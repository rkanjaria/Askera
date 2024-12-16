package com.ai.askera.chat.presentation.home_screen

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.askera.chat.domain.models.Conversation
import com.ai.askera.chat.presentation.components.ChatBar
import com.ai.askera.chat.presentation.components.ChatHistoryCard
import com.ai.askera.chat.presentation.home_screen.components.GreetingCard
import com.ai.askera.chat.presentation.home_screen.components.PromptSection
import com.ai.askera.chat.presentation.home_screen.components.TitleSection
import com.ai.askera.chat.presentation.models.toConversationUi
import com.ai.askera.core.domain.util.prompts
import com.ai.askera.core.navigation.ChatHistoryScreen
import com.ai.askera.core.navigation.ChatScreen
import com.ai.askera.core.presentation.components.PillText
import com.ai.askera.core.presentation.util.clickableWithoutRipple
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.size


@Composable
fun HomeScreen(
    navController: NavController,
    state: HomeUiState,
    onAction: (HomeActions) -> Unit
) {

    val prompts = state.prompts
    val chatHistory = state.chatHistory

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
            contentPadding = PaddingValues(
                top = MaterialTheme.size.extraLarge,
                bottom = MaterialTheme.size.dp100.plus(
                    WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
                )
            ),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.size.extraLarge)
        ) {

            item {
                GreetingCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = MaterialTheme.size.extraLarge),
                )
            }

            item {
                TitleSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = MaterialTheme.size.extraLarge),
                    title = "Select the topic or write your own questions below"
                )
            }

            item {
                PromptSection(
                    modifier = Modifier.fillMaxWidth(),
                    promptList = prompts,
                    onPromptClicked = { promptUi ->
                        navController.navigate(
                            ChatScreen(
                                prompt = promptUi.prompt,
                            )
                        )
                    }
                )
            }

            if (chatHistory.isNotEmpty()) {

                item {

                    TitleSection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = MaterialTheme.size.extraLarge.times(2),
                                start = MaterialTheme.size.extraLarge,
                                end = MaterialTheme.size.extraLarge,
                                bottom = MaterialTheme.size.default,
                            ),
                        title = "Recent chats"
                    )
                }

                items(chatHistory) { conversationHistory ->
                    ChatHistoryCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = MaterialTheme.size.extraLarge,
                                end = MaterialTheme.size.extraLarge,
                            ),
                        conversation = conversationHistory,
                        onChatHistoryClicked = { conversation ->
                            val conversationId = conversation.id
                            navController.navigate(
                                ChatScreen(
                                    conversationId = conversationId
                                )
                            )
                        }
                    )
                }

                item {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = MaterialTheme.size.extraLarge,
                                end = MaterialTheme.size.extraLarge,
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        PillText(
                            modifier = Modifier.clickableWithoutRipple {
                                navController.navigate(ChatHistoryScreen)
                            },
                            title = "See all"
                        )
                    }
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
                navController.navigate(
                    ChatScreen(
                        prompt = userMessage
                    )
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    AskeraTheme {

        HomeScreen(
            navController = rememberNavController(),
            state = HomeUiState(
                prompts = prompts,
                chatHistory = prompts.take(3).map {
                    Conversation(title = it.prompt)
                }.map { it.toConversationUi() }
            ),
            onAction = {}
        )
    }
}