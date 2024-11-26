package com.ai.askera.ui.theme

import androidx.compose.ui.graphics.Color

val cardColorPurple = Color(0xFFF4E0F1)
val cardColorPink = Color(0xFFCFC8EF)

private object DarkTheme {
    val background = Color(0xFF1C202A)
    val backgroundDark = Color(0xFF161921)
    val grey = Color(0xFF272C39)
    val lightGrey = Color(0xFF313849)
    val title = Color(0xFFFFFFFF)
    val subtitle = Color(0xFF82899C)
    val primary = Color(0xFF7269E3)
    val primaryDark = Color(0xFF5148C9)
}

private object LightTheme {
    val background = Color(0xFFFFFFFF)
    val backgroundDark = Color(0xFFFFFFFF)
    val grey = Color(0xFFEfEEf5)
    val lightGrey = Color(0xFFEEEEEE)
    val title = Color(0xFF12131A)
    val subtitle = Color(0xFF727277)
    val primary = Color(0xFF7269E3)
    val primaryDark = Color(0xFF5148C9)
}

sealed class ThemeColors(
    val background: Color,
    val darkBackground: Color,
    val mediumBackground: Color,
    val lightBackground: Color,
    val primary: Color,
    val primaryDark: Color,
    val textTitle: Color,
    val textSubtitle: Color
)  {

    data object Night: ThemeColors(
        background = DarkTheme.background,
        darkBackground = DarkTheme.backgroundDark,
        mediumBackground = DarkTheme.grey,
        lightBackground = DarkTheme.lightGrey,
        primary = DarkTheme.primary,
        primaryDark = DarkTheme.primaryDark,
        textTitle = DarkTheme.title,
        textSubtitle = DarkTheme.subtitle,
    )

    data object Day: ThemeColors(
        background = LightTheme.background,
        darkBackground = LightTheme.backgroundDark,
        mediumBackground = LightTheme.grey,
        lightBackground = LightTheme.lightGrey,
        primary = LightTheme.primary,
        primaryDark = LightTheme.primaryDark,
        textTitle = LightTheme.title,
        textSubtitle = LightTheme.subtitle,
    )
}
