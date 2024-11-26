package com.ai.askera.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ai.askera.R


private val euclidCircular = FontFamily(
    Font(R.font.euclid_circular_light, FontWeight.Light),
    Font(R.font.euclid_circular_regular, FontWeight.Normal),
    Font(R.font.euclid_circular_medium, FontWeight.Medium),
    Font(R.font.euclid_circular_semi_bold, FontWeight.SemiBold),
    Font(R.font.euclid_circular_bold, FontWeight.Bold)
)

val Typography = Typography()

data class Title(

    val megaLarge: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
        lineHeight = 30.sp
    ),

    val extraLarge: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 30.sp
    ),

    val large: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 26.sp
    ),
    val medium: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    val small: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),

    val extraSmall: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )
)

data class Subtitle(

    val megaLarge: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        lineHeight = 30.sp
    ),

    val extraLarge: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 30.sp
    ),

    val large: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 26.sp
    ),
    val medium: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    val small: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),

    val extraSmall: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )
)

data class Body(

    val extraLarge: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 30.sp
    ),

    val large: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 30.sp
    ),

    val medium: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),

    val small: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),

    val extraSmall: TextStyle = TextStyle(
        fontFamily = euclidCircular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

val LocalTitle = compositionLocalOf { Title() }
val LocalBody = compositionLocalOf { Body() }
val LocalSubtitle = compositionLocalOf { Subtitle() }

val MaterialTheme.title: Title
    @Composable @ReadOnlyComposable get() = LocalTitle.current

val MaterialTheme.subtitle: Subtitle
    @Composable @ReadOnlyComposable get() = LocalSubtitle.current
val MaterialTheme.body: Body
    @Composable @ReadOnlyComposable get() = LocalBody.current
