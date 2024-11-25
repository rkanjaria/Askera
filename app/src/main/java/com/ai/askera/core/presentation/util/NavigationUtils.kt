package com.ai.askera.core.presentation.util

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavController.getCurrentRoute(): String? {
    val backStackEntry by this.currentBackStackEntryAsState()
    return backStackEntry?.destination?.route
}


inline fun <reified T : Any> NavGraphBuilder.slideScreenAnimation(
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline screen: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {

    val animationDuration = 300
    val negativeAnimationDuration = animationDuration * -1

    composable<T>(
        deepLinks = deepLinks,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { animationDuration },
                animationSpec = tween(animationDuration)
            ) + fadeIn(
                animationSpec = tween(animationDuration)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { negativeAnimationDuration },
                animationSpec = tween(animationDuration)
            ) + fadeOut(
                animationSpec = tween(animationDuration)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { negativeAnimationDuration },
                animationSpec = tween(animationDuration)
            ) + fadeIn(
                animationSpec = tween(animationDuration)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { animationDuration },
                animationSpec = tween(animationDuration)
            ) + fadeOut(
                animationSpec = tween(animationDuration)
            )
        },
        content = { screen(it) }
    )
}

inline fun <reified T : Any> NavGraphBuilder.fadeScreenAnimation(
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline screen: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {

    val animationDuration = 300

    composable<T>(
        deepLinks = deepLinks,
        enterTransition = {
            fadeIn(animationSpec = tween(animationDuration))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(animationDuration))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(animationDuration))
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(animationDuration))
        },
        content = { screen(it) }
    )
}

inline fun <reified T : Any> NavGraphBuilder.fadeInWithSlideOutAnimation(
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline screen: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {

    val animationDuration = 300
    val negativeAnimationDuration = animationDuration * -1

    composable<T>(
        deepLinks = deepLinks,
        enterTransition = {
            fadeIn(animationSpec = tween(animationDuration))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { negativeAnimationDuration },
                animationSpec = tween(animationDuration)
            ) + fadeOut(
                animationSpec = tween(animationDuration)
            )
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(animationDuration))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { animationDuration },
                animationSpec = tween(animationDuration)
            ) + fadeOut(
                animationSpec = tween(animationDuration)
            )
        },
        content = { screen(it) }
    )
}

