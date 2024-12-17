package com.ai.askera.chat.presentation.chat_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ai.askera.R
import com.ai.askera.chat.presentation.models.MessageUi
import com.ai.askera.ui.theme.AskeraTheme
import com.ai.askera.ui.theme.body
import com.ai.askera.ui.theme.size
import com.airbnb.lottie.RenderMode
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun MessageCellGenerating(
    modifier: Modifier = Modifier,
) {

    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.animation_loading
        )
    )

    Box(
        modifier = modifier
    ) {

        LottieAnimation(
            composition = preloaderLottieComposition,
            isPlaying = true,
            iterations = LottieConstants.IterateForever,
        )
    }
}

@PreviewLightDark
@Composable
private fun MessageCellGeneratingPreview() {
    AskeraTheme {
        MessageCellGenerating()
    }
}