package com.ai.askera.chat.presentation.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class PromptUi(
    @DrawableRes val icon: Int,
    val title: String? = null,
    val subtitle: String? = null,
    val prompt: String? = null,
)