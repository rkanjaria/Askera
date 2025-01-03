package com.ai.askera.chat.presentation.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.chat.presentation.models.PromptUi
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.DarkTheme
import com.ai.askera.ui.theme.size


@Composable
fun PromptSection(
    modifier: Modifier = Modifier,
    promptList: List<PromptUi>,
    onPromptClicked: (PromptUi) -> Unit = {}
) {

    val promptColors = listOf(
        DarkTheme.cardColorGreen,
        DarkTheme.cardColorPurple,
        DarkTheme.cardColorYellow,
        DarkTheme.cardColorPink,
        DarkTheme.cardColorDarkGreen,
    )

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = MaterialTheme.size.extraLarge,
            end = MaterialTheme.size.extraLarge,
        ),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.size.extraLarge)
    ) {

        items(promptList.size) { index ->
            val color = promptColors[index % promptColors.size]
            val prompt = promptList[index]
            PromptCard(
                prompt = prompt,
                color = color,
                onPromptClicked = onPromptClicked
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PromptSectionPreview() {
    AskeraTheme {
        PromptSection(
            modifier = Modifier.fillMaxWidth(),
            promptList = emptyList()
        )
    }
}