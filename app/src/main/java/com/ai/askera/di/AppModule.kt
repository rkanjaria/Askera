package com.ai.askera.di


import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.ai.askera.onboarding.presentation.splash.SplashViewModel
import com.ai.askera.chat.presentation.chat_screen.ChatViewModel
import com.ai.askera.chat.presentation.home.HomeViewModel

val appModule = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::ChatViewModel)
    viewModelOf(::HomeViewModel)
}