package com.ai.askera.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val darkColorPalette = darkColorScheme(
    primary = ThemeColors.Night.primary,
    secondary = ThemeColors.Night.primaryDark,
    background = ThemeColors.Night.darkBackground,
    surface = ThemeColors.Night.background,
    surfaceDim = ThemeColors.Night.mediumBackground,
    surfaceBright = ThemeColors.Night.lightBackground,
    onSurface = ThemeColors.Night.textTitle,
    onSurfaceVariant = ThemeColors.Night.textSubtitle
)
private val lightColorPalette = lightColorScheme(
    primary = ThemeColors.Day.primary,
    secondary = ThemeColors.Day.primaryDark,
    background = ThemeColors.Day.darkBackground,
    surface = ThemeColors.Day.background,
    surfaceDim = ThemeColors.Day.mediumBackground,
    surfaceBright = ThemeColors.Day.lightBackground,
    onSurface = ThemeColors.Day.textTitle,
    onSurfaceVariant = ThemeColors.Day.textSubtitle
)

@Composable
fun AskeraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColorPalette else lightColorPalette

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}