package com.ai.askera.ui.theme

import androidx.compose.ui.graphics.Color

object DarkTheme {
    val background = Color(0xFF0A0A0A)
    val backgroundDark = Color(0xFF0A0A0A)
    val grey = Color(0xFF1B1B1B)
    val lightGrey = Color(0xFF252626)
    val title = Color(0xFFFFFFFF)
    val subtitle = Color(0xFF9A9A9A)
    val primary = Color(0xFF7269E3)
    val primaryDark = Color(0xFF5148C9)

    val cardColorPurple = Color(0xFFC9C6FF)
    val cardColorPink = Color(0xFFFFD0F8)
    val cardColorYellow = Color(0xFFFFDAAB) //ffd18d
    val cardColorGreen = Color(0xFFE5FFA5)
    val cardColorDarkGreen = Color(0xFFBEFFE2)
}

object LightTheme {
    val background = Color(0xFFFFFFFF)
    val backgroundDark = Color(0xFFFFFFFF)
    val grey = Color(0xFFF6F6F9)
    val lightGrey = Color(0xFFEFEFEF)
    val title = Color(0xFF12131A)
    val subtitle = Color(0xFF9A9A9A)
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
