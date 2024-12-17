package com.ai.askera.onboarding.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SplashViewModel() : ViewModel() {

    private val _eventFlow = Channel<SplashUiEvents>()
    val eventFlow = _eventFlow.receiveAsFlow()

    init {
        viewModelScope.launch {
            startLogoAnimation()
            delay(1000)
            endLogoAnimation()
            navigateToHomeScreen()
        }
    }

    private suspend fun startLogoAnimation() {
        // delay to start the logo animation
        delay(150)
        _eventFlow.send(SplashUiEvents.StartLogoAnimation)
    }

    private suspend fun endLogoAnimation() {
        // minimum delay to show the splash screen
        delay(1000)
        _eventFlow.send(SplashUiEvents.EndLogoAnimation)
        // delay for animation logo
        delay(300)
    }

    private suspend fun navigateToHomeScreen() {
        // delay after the logo animation completes
        delay(150)
        _eventFlow.send(SplashUiEvents.NavigateToHomeScreen)
    }
}