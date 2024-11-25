package com.ai.askera.core.presentation.util

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import com.ai.askera.core.presentation.util.SnackBarType

data class SimpleSnackBarVisuals(
    override val actionLabel: String? = null,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    override val message: String,
    override val withDismissAction: Boolean = false,
    val snackBarType: SnackBarType
) : SnackbarVisuals