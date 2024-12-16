package com.ai.askera.core.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.size
import com.ai.askera.ui.theme.subtitle

@Composable
fun PillText(
    modifier: Modifier = Modifier,
    title: String
) {

    val borderColor = MaterialTheme.colorScheme.surfaceBright
    val textColor = MaterialTheme.colorScheme.onSurfaceVariant

    Box(
        modifier = modifier
            .border(
                width = MaterialTheme.size.dp2,
                color = borderColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(
                start = MaterialTheme.size.extraLarge,
                end = MaterialTheme.size.extraLarge,
                top = MaterialTheme.size.extraSmall,
                bottom = MaterialTheme.size.extraSmall,
            ),
            text = title,
            style = MaterialTheme.subtitle.small.copy(
                color = textColor,
            ),
            textAlign = TextAlign.Center
        )
    }
}

@PreviewLightDark
@Composable
private fun PillTextPreview() {
    AskeraTheme {

        PillText(
            modifier = Modifier,
            title = "View All"
        )
    }
}