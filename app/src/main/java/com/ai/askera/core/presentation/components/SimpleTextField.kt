package com.ai.askera.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit,
    cursorColor: Color = MaterialTheme.colorScheme.primary,
    textStyle: TextStyle,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceBright,
    padding: PaddingValues = PaddingValues(),
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = RectangleShape,
    hint: String = "",
    hintColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {

    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        modifier = modifier.height(IntrinsicSize.Max),
        value = text,
        onValueChange = onValueChanged,
        cursorBrush = SolidColor(cursorColor),
        textStyle = textStyle,
        maxLines = maxLines,
        minLines = minLines,
        singleLine = maxLines == 1,
        enabled = enabled,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        interactionSource = interactionSource,
        keyboardActions = keyboardActions
    ) { innerTextField ->

        TextFieldDefaults.DecorationBox(
            value = text,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            placeholder = {
                Text(
                    text = hint,
                    style = textStyle,
                    color = hintColor
                )
            },
            shape = shape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                disabledContainerColor = LightGray,
                cursorColor = cursorColor,
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
            ),
            contentPadding = padding,
        )
    }
}

@ExperimentalMaterial3Api
@PreviewLightDark
@Composable
fun SimpleTextFieldPreview() {
    AskeraTheme {
        SimpleTextField(
            modifier = Modifier.fillMaxWidth(),
            padding = PaddingValues(all = MaterialTheme.size.extraLarge),
            shape = CircleShape,
            text = "",
            onValueChanged = {},
            textStyle = MaterialTheme.body.medium,
            hint = "Type Anything",
            enabled = true,
        )
    }
}