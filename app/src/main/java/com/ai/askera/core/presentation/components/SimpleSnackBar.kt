package com.ai.askera.core.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ai.askera.core.presentation.util.SnackBarType
import com.ai.askera.core.presentation.util.clickableWithoutRipple
import com.ai.askera.ui.theme.size
import com.ai.askera.ui.theme.subtitle
import com.ai.askera.ui.theme.title
import com.ai.askera.core.presentation.util.SimpleSnackBarVisuals as SimpleSnackBarVisuals1

@Composable
fun SimpleSnackBar(
    snackBarVisuals: SimpleSnackBarVisuals1,
    onAction: () -> Unit = {}
) {

    val snackBarColor = when (snackBarVisuals.snackBarType) {
        SnackBarType.INFO -> MaterialTheme.colorScheme.primary
        SnackBarType.ERROR -> MaterialTheme.colorScheme.primary
        SnackBarType.SUCCESS -> MaterialTheme.colorScheme.primary
    }

    val actionLabelColor = when (snackBarVisuals.snackBarType) {
        SnackBarType.INFO -> Color.White
        SnackBarType.ERROR -> Color.White
        SnackBarType.SUCCESS -> Color.White
    }

    val textColor = when (snackBarVisuals.snackBarType) {
        SnackBarType.INFO -> Color.White
        SnackBarType.ERROR -> Color.White
        SnackBarType.SUCCESS -> Color.White
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                all = MaterialTheme.size.extraLarge
            ),
        shape = RoundedCornerShape(MaterialTheme.size.extraDefault),
        color = snackBarColor,
        shadowElevation = MaterialTheme.size.default,
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(all = MaterialTheme.size.large)
                    .wrapContentHeight(),
                text = snackBarVisuals.message,
                style = MaterialTheme.subtitle.medium.copy(
                    color = textColor
                )
            )

            if (!snackBarVisuals.actionLabel.isNullOrEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = MaterialTheme.size.large,
                            bottom = MaterialTheme.size.large,
                            end = MaterialTheme.size.large,
                        )
                        .clickableWithoutRipple { onAction() }
                        .wrapContentHeight(),
                    text = snackBarVisuals.actionLabel.uppercase(),
                    style = MaterialTheme.title.extraSmall.copy(
                        color = actionLabelColor
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF161A1B)
@Composable
fun SimpleSnackBarInfoPreview() {

    SimpleSnackBar(
        snackBarVisuals = SimpleSnackBarVisuals1(
            actionLabel = null,
            duration = SnackbarDuration.Long,
            message = "Update downloaded!",
            snackBarType = SnackBarType.INFO
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF161A1B)
@Composable
fun SimpleSnackBarInfoActionPreview() {
    SimpleSnackBar(
        snackBarVisuals = SimpleSnackBarVisuals1(
            actionLabel = "Install",
            duration = SnackbarDuration.Long,
            message = "Update downloaded!",
            snackBarType = SnackBarType.INFO
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF161A1B)
@Composable
fun SimpleSnackBarErrorPreview() {

    SimpleSnackBar(
        snackBarVisuals = SimpleSnackBarVisuals1(
            actionLabel = null,
            duration = SnackbarDuration.Short,
            message = "Update downloaded!",
            withDismissAction = false,
            snackBarType = SnackBarType.ERROR
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF161A1B)
@Composable
fun SimpleSnackBarErrorActionPreview() {
    SimpleSnackBar(
        snackBarVisuals = SimpleSnackBarVisuals1(
            actionLabel = "Action",
            duration = SnackbarDuration.Short,
            message = "Update downloaded!",
            withDismissAction = false,
            snackBarType = SnackBarType.ERROR
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF161A1B)
@Composable
fun SimpleSnackBarSuccessPreview() {
    SimpleSnackBar(
        snackBarVisuals = SimpleSnackBarVisuals1(
            actionLabel = null,
            duration = SnackbarDuration.Short,
            message = "Update downloaded!",
            withDismissAction = false,
            snackBarType = SnackBarType.SUCCESS
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF161A1B)
@Composable
fun SimpleSnackBarSuccessActionPreview() {
    SimpleSnackBar(
        snackBarVisuals = SimpleSnackBarVisuals1(
            actionLabel = "Install",
            duration = SnackbarDuration.Short,
            message = "Your update is ready!",
            withDismissAction = false,
            snackBarType = SnackBarType.SUCCESS
        )
    )
}