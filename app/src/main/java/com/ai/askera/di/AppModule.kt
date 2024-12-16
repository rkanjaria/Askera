package com.ai.askera.di


import androidx.room.Room
import com.ai.askera.chat.data.local.ChatDataSourceImpl
import com.ai.askera.chat.domain.ChatDataSource
import com.ai.askera.chat.presentation.history_screen.ChatHistoryViewModel
import com.ai.askera.chat.presentation.chat_screen.ChatViewModel
import com.ai.askera.chat.presentation.home_screen.HomeViewModel
import com.ai.askera.core.data.local.AskeraDatabase
import com.ai.askera.onboarding.presentation.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    single { ChatDataSourceImpl(get()) }.bind(ChatDataSource::class)

    single {
        Room.databaseBuilder(
            context = androidApplication(),
            klass = AskeraDatabase::class.java,
            name = "askera_db"
        ).build()
    }

    viewModelOf(::SplashViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::ChatViewModel)
    viewModelOf(::ChatHistoryViewModel)
}