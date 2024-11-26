package com.ai.askera.chat.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.chat.presentation.models.PromptUi
import com.ai.askera.core.domain.util.prompts
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.cardColorPink
import com.ai.askera.ui.theme.size


@Composable
fun PromptCard(
    modifier: Modifier = Modifier,
    prompt: PromptUi,
    color: Color
) {

    val promptCardShape = RoundedCornerShape(MaterialTheme.size.dp24)

    Box(
        modifier = modifier
            .width(MaterialTheme.size.dp200)
            .height(MaterialTheme.size.dp250)
            .clip(promptCardShape)
            .background(color = color)
    ) { }
}

@PreviewLightDark
@Composable
private fun PromptCardPreview() {
    AskeraTheme {
        PromptCard(
            modifier = Modifier.fillMaxWidth(),
            prompt = promptUi,
            color = cardColorPink,
        )
    }
}

internal val promptUi = prompts.first()