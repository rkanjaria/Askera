package com.ai.askera.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.ai.askera.core.presentation.util.fadeInWithSlideOutAnimation
import com.ai.askera.core.presentation.util.slideScreenAnimation
import com.ai.askera.onboarding.presentation.splash.SplashScreen
import com.ai.askera.onboarding.presentation.splash.SplashViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.onBoardingNavigationGraph(
    navController: NavController,
) {
    navigation<Graph.OnBoarding>(
        startDestination = SplashScreen
    ) {

        fadeInWithSlideOutAnimation<SplashScreen> {

            val viewModel: SplashViewModel = koinViewModel()
            val uiEvents = viewModel.eventFlow

            SplashScreen(
                navController = navController,
                uiEvents = uiEvents
            )
        }

        slideScreenAnimation<WalkthroughScreen> {

            /*val viewModel: WalkthroughViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val uiEvents = viewModel.eventFlow

            WalkthroughScreen(
                navController = navController,
                state = state,
                uiEvents = uiEvents,
                onEvent = viewModel::onEvent
            )*/
        }
    }
}