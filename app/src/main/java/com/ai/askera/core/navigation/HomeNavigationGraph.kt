package com.ai.askera.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ai.askera.chat.presentation.chat_screen.ChatScreen
import com.ai.askera.chat.presentation.chat_screen.ChatViewModel
import com.ai.askera.chat.presentation.home.HomeScreen
import com.ai.askera.chat.presentation.home.HomeViewModel
import com.ai.askera.core.presentation.util.fadeScreenAnimation
import com.ai.askera.core.presentation.util.slideScreenAnimation
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeNavigationGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ) {

        fadeScreenAnimation<HomeScreen> {

            val viewModel: HomeViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            HomeScreen(
                navController = navController,
                state = state,
                onAction = viewModel::onAction
            )
        }

        slideScreenAnimation<ChatScreen> {

            val viewModel: ChatViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            ChatScreen(
                navController = navController,
                state = state,
                onAction = viewModel::onAction
            )
        }
    }
}

