package com.ai.askera.onboarding.presentation.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ai.askera.R
import com.ai.askera.core.navigation.Graph
import com.ai.askera.core.presentation.util.ObserveAsEvents
import com.ai.askera.ui.theme.size
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navController: NavController,
    uiEvents: Flow<SplashUiEvents>,
) {

    val scope = rememberCoroutineScope()

    var logoVisibility by remember { mutableStateOf(false) }

    fun delayAnimation() {
        scope.launch {
            // delay and then hide the
            delay(1300)
            logoVisibility = !logoVisibility
            delay(400)
            // wait 100 ms after animation ends
        }
    }

    ObserveAsEvents(flow = uiEvents) { event ->

        when (event) {

            is SplashUiEvents.NavigateToHomeScreen -> {
                delayAnimation()
                navController.navigate(Graph.Home) {
                    popUpTo(Graph.OnBoarding) { inclusive = true }
                }
            }

            SplashUiEvents.StartLogoAnimation -> {
                logoVisibility = true
            }

            SplashUiEvents.EndLogoAnimation -> {
                logoVisibility = false
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary,
                    )
                )
            )
            .padding(bottom = MaterialTheme.size.megaLarge),
        contentAlignment = Alignment.Center
    ) {

        AnimatedVisibility(
            visible = logoVisibility,
            enter = expandHorizontally { 20 },
            exit = shrinkHorizontally(
                animationSpec = tween(),
                shrinkTowards = Alignment.End,
            )
        ) {

            Icon(
                modifier = Modifier.size(
                    MaterialTheme.size.dp100
                ),
                imageVector = ImageVector.vectorResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Logo",
                tint = Color.White
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF161A1B)
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        navController = rememberNavController(),
        uiEvents = flowOf()
    )
}