package com.ai.askera.chat.presentation.home

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.askera.chat.presentation.chat_screen.ChatActions
import com.ai.askera.chat.presentation.chat_screen.ChatScreen
import com.ai.askera.chat.presentation.chat_screen.components.MessageCellAi
import com.ai.askera.chat.presentation.components.ChatBar
import com.ai.askera.chat.presentation.home.components.GreetingCard
import com.ai.askera.chat.presentation.home.components.PromptSection
import com.ai.askera.chat.presentation.home.components.TitleSection
import com.ai.askera.chat.presentation.models.toMessageUi
import com.ai.askera.core.domain.util.dummyConversation
import com.ai.askera.core.domain.util.prompts
import com.ai.askera.core.navigation.ChatScreen
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size
import com.ai.askera.ui.theme.subtitle
import com.ai.askera.ui.theme.title


@Composable
fun HomeScreen(
    navController: NavController,
    state: HomeUiState,
    onAction: (HomeActions) -> Unit
) {

    val prompts = state.prompts

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
                            ChatScreen(prompt = promptUi.prompt)
                        )
                    }
                )
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
                navController.navigate(ChatScreen(prompt = userMessage))
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
            state = HomeUiState(prompts = prompts),
            onAction = {}
        )
    }
}