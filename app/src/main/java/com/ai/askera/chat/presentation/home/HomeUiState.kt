package com.ai.askera.chat.presentation.home

import com.ai.askera.chat.presentation.models.PromptUi

data class HomeUiState(
    val isLoading: Boolean = false,
    val prompts: List<PromptUi> = emptyList(),
)