package com.ai.askera.chat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.R
import com.ai.askera.core.presentation.components.SimpleTextField
import com.ai.askera.core.presentation.util.clickableWithoutRipple
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size

@Composable
fun ChatBar(
    modifier: Modifier = Modifier,
    onSendButtonClicked: (String) -> Unit
) {

    val isDarkMode = isSystemInDarkTheme()
    val chatBoxColor = if (isDarkMode)
        MaterialTheme.colorScheme.surfaceBright else MaterialTheme.colorScheme.surface

    val chatBoxShape = RoundedCornerShape(
        size = MaterialTheme.size.dp28
    )

    var typedMessage by rememberSaveable { mutableStateOf("") }

    SimpleTextField(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (isDarkMode.not()) {
                    Modifier.border(
                        width = MaterialTheme.size.dp2,
                        color = MaterialTheme.colorScheme.surfaceBright,
                        shape = chatBoxShape
                    )
                } else {
                    Modifier
                }
            ),
        shape = chatBoxShape,
        backgroundColor = chatBoxColor,
        padding = PaddingValues(
            start = MaterialTheme.size.extraLarge,
            end = MaterialTheme.size.medium,
            top = MaterialTheme.size.medium,
            bottom = MaterialTheme.size.medium
        ),
        hint = "Ask anything",
        text = typedMessage,
        onValueChanged = { text ->
            typedMessage = text
        },
        textStyle = MaterialTheme.body.medium.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        maxLines = 5,
        trailingIcon = {

            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .clickableWithoutRipple {
                            if (typedMessage
                                    .trim()
                                    .isNotEmpty()
                            ) {
                                onSendButtonClicked(typedMessage.trim())
                                typedMessage = ""
                            }
                        }
                        .padding(all = MaterialTheme.size.default)
                        .size(MaterialTheme.size.dp40)
                        .clip(CircleShape)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.secondary,
                                )
                            )
                        )
                        .padding(all = MaterialTheme.size.default),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_forward),
                        contentDescription = "Send",
                        tint = Color.White
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences
        )
    )
}

@PreviewLightDark
@Composable
private fun ChatBarPreview() {
    AskeraTheme {
        ChatBar(
            modifier = Modifier.fillMaxWidth(),
            onSendButtonClicked = {}
        )
    }
}