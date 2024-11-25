package com.ai.askera.core.presentation.util

import androidx.compose.material3.SnackbarDuration
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


data class SnackBarEvent(
    val message: String,
    val snackBarType: SnackBarType = SnackBarType.INFO,
    val snackBarDuration: SnackbarDuration = SnackbarDuration.Short,
    val snackBarAction: SnackBarAction? = null
)

data class SnackBarAction(
    val name: String,
    val action: () -> Unit
)

object SnackBarController {

    private val _events = Channel<SnackBarEvent>()
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event: SnackBarEvent) {
        _events.send(event)
    }
}