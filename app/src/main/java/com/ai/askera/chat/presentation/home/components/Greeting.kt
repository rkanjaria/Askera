package com.ai.askera.chat.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.DarkTheme
import com.ai.askera.ui.theme.subtitle
import com.ai.askera.ui.theme.title

@Composable
fun GreetingCard(
    modifier: Modifier = Modifier
) {

    val greetingTextColor = //if(isSystemInDarkTheme())
        MaterialTheme.colorScheme.onSurface

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.3f),
            text = "Hey there! I'm",
            style = MaterialTheme.title.extraLarge.copy(
                color = greetingTextColor,
                fontSize = 50.sp,
                lineHeight = 0.sp
            ),
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Askera",
            style = MaterialTheme.title.extraLarge.copy(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        DarkTheme.cardColorPink,
                    )
                ),
                fontSize = 50.sp,
                lineHeight = 0.sp
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun GreetingCardPreview() {
    AskeraTheme {
        GreetingCard()
    }
}