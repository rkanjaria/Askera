package com.ai.askera.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Size(
    val none: Dp = 0.dp,
    val minor: Dp = 4.dp,
    val smallDefault: Dp = 6.dp,
    val default: Dp = 8.dp,
    val extraDefault: Dp = 10.dp,
    val extraSmall: Dp = 12.dp,
    val small: Dp = 14.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 18.dp,
    val extraLarge: Dp = 20.dp,
    val megaLarge: Dp = 24.dp,

    //Actual sizes:
    val dp1: Dp = 1.dp,
    val dp1_5: Dp = 1.5.dp,
    val dp2: Dp = 2.dp,
    val dp4: Dp = 4.dp,
    val dp6: Dp = 6.dp,
    val dp8: Dp = 8.dp,
    val dp12: Dp = 12.dp,
    val dp14: Dp = 14.dp,
    val dp16: Dp = 16.dp,
    val dp18: Dp = 18.dp,
    val dp20: Dp = 20.dp,
    val dp24: Dp = 24.dp,
    val dp28: Dp = 28.dp,
    val dp30: Dp = 30.dp,
    val dp32: Dp = 32.dp,
    val dp38: Dp = 38.dp,
    val dp40: Dp = 40.dp,
    val dp44: Dp = 44.dp,
    val dp46: Dp = 46.dp,
    val dp48: Dp = 48.dp,
    val dp50: Dp = 50.dp,
    val dp56: Dp = 56.dp,
    val dp60: Dp = 60.dp,
    val dp70: Dp = 70.dp,
    val dp80: Dp = 80.dp,
    val dp90: Dp = 90.dp,
    val dp100: Dp = 100.dp,
    val dp110: Dp = 110.dp,
    val dp120: Dp = 120.dp,
    val dp130: Dp = 130.dp,
    val dp140: Dp = 140.dp,
    val dp150: Dp = 150.dp,
    val dp180: Dp = 180.dp,
    val dp200: Dp = 200.dp,
    val dp220: Dp = 220.dp,
    val dp230: Dp = 230.dp,
    val dp240: Dp = 240.dp,
    val dp250: Dp = 250.dp,
    val dp260: Dp = 260.dp,
    val dp270: Dp = 270.dp,
    val dp280: Dp = 280.dp,
    val dp300: Dp = 300.dp,
    val dp320: Dp = 320.dp,
    val dp500: Dp = 500.dp,
    val dp490: Dp = 490.dp
)

data class TextSize(
    val default: TextUnit = 14.sp,
    val extraSmall: TextUnit = 12.sp,
    val small: TextUnit = 14.sp,
    val medium: TextUnit = 16.sp,
    val large: TextUnit = 18.sp,
    val extraLarge: TextUnit = 20.sp
)

val LocalSize = compositionLocalOf { Size() }
val LocalTextSize = compositionLocalOf { TextSize() }

val MaterialTheme.size: Size
    @Composable @ReadOnlyComposable get() = LocalSize.current

val MaterialTheme.textSize: TextSize
    @Composable @ReadOnlyComposable get() = LocalTextSize.current