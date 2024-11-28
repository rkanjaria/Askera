package com.ai.askera.chat.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.R
import com.ai.askera.chat.presentation.models.PromptUi
import com.ai.askera.core.domain.util.prompts
import com.ai.askera.core.presentation.util.clickableWithoutRipple
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.DarkTheme
import com.ai.askera.ui.theme.LightTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size
import com.ai.askera.ui.theme.title
import com.ai.askera.ui.theme.translucentBlack


@Composable
fun PromptCard(
    modifier: Modifier = Modifier,
    prompt: PromptUi,
    color: Color,
    onPromptClicked: (PromptUi) -> Unit = {}
) {

    val promptCardShape = RoundedCornerShape(MaterialTheme.size.dp24)

    Column(
        modifier = modifier
            .width(MaterialTheme.size.dp200)
            .clip(promptCardShape)
            .background(color = color)
            .padding(all = MaterialTheme.size.extraLarge)
            .clickableWithoutRipple { onPromptClicked(prompt) }
    ) {

        Icon(
            modifier = Modifier.size(MaterialTheme.size.dp30),
            imageVector = ImageVector.vectorResource(id = prompt.icon),
            contentDescription = "Send",
            tint = LightTheme.title
        )

        Spacer(modifier = Modifier.height(MaterialTheme.size.dp100))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = prompt.title ?: "",
                style = MaterialTheme.title.large.copy(
                    color = LightTheme.title,
                )
            )

            Icon(
                modifier = Modifier
                    .size(MaterialTheme.size.dp18),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_forward),
                contentDescription = "",
                tint = LightTheme.title
            )
        }

        /* Text(
             modifier = Modifier.fillMaxWidth(),
             text = prompt.title ?: "",
             style = MaterialTheme.title.large.copy(
                 color = LightTheme.title,
             ),
         )*/

        Spacer(modifier = Modifier.height(MaterialTheme.size.extraSmall))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = prompt.subtitle ?: "",
            style = MaterialTheme.body.small.copy(
                color = LightTheme.title
            ),
        )
    }
}

@PreviewLightDark
@Composable
private fun PromptCardPreview() {
    AskeraTheme {
        PromptCard(
            modifier = Modifier,
            prompt = promptUi,
            color = DarkTheme.cardColorPink,
        )
    }
}

internal val promptUi = prompts.first()