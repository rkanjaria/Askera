package com.ai.askera.chat.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun TitleSection(
    modifier: Modifier = Modifier,
    title: String
) {

    val textColor = MaterialTheme.colorScheme.onSurfaceVariant

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.width(MaterialTheme.size.dp200),
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
private fun HomeScreenPreview() {
    AskeraTheme {

        TitleSection(
            modifier = Modifier.fillMaxWidth(),
            title = ""
        )
    }
}