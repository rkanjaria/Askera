package com.ai.askera.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.ai.askera.core.navigation.RootNavigationGraph
import com.ai.askera.core.presentation.components.SimpleSnackBar
import com.ai.askera.core.presentation.util.ObserveAsEvents
import com.ai.askera.core.presentation.util.SimpleSnackBarVisuals
import com.ai.askera.core.presentation.util.SnackBarController
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.size
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        setContent {
            AskeraTheme {

                val onBoardingNavController = rememberNavController()
                val homeNavController = rememberNavController()

                val scope = rememberCoroutineScope()
                val snackBarHostState = remember { SnackbarHostState() }

                ObserveAsEvents(
                    flow = SnackBarController.events,
                    key1 = snackBarHostState
                ) { event ->
                    scope.launch {
                        snackBarHostState.currentSnackbarData?.dismiss()

                        val result = snackBarHostState.showSnackbar(
                            SimpleSnackBarVisuals(
                                message = event.message,
                                snackBarType = event.snackBarType,
                                actionLabel = event.snackBarAction?.name,
                                duration = event.snackBarDuration
                            )
                        )

                        if (result == SnackbarResult.ActionPerformed) {
                            event.snackBarAction?.action?.invoke()
                        }
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(
                            modifier = Modifier.padding(bottom = MaterialTheme.size.extraLarge),
                            hostState = snackBarHostState,
                            snackbar = { snackBarData ->

                                val simpleVisuals = snackBarData.visuals as SimpleSnackBarVisuals

                                SimpleSnackBar(
                                    snackBarVisuals = simpleVisuals,
                                    onAction = { snackBarData.performAction() }
                                )
                            }
                        )
                    }
                ) {
                    RootNavigationGraph(
                        onBoardingNavController = onBoardingNavController,
                        homeNavController = homeNavController
                    )
                }
            }
        }
    }
}