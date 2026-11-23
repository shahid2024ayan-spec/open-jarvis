package com.openjarvis.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Shared VOID palette used by the original OpenJarvis dashboard.
 * Kept in one place so screens use the same accessible dark theme.
 */
object VoidColor {
    val Void950 = Color(0xFF080A12)
    val Void900 = Color(0xFF101321)
    val Void800 = Color(0xFF191D30)
    val Violet = Color(0xFF9B7BFF)
    val Cyan = Color(0xFF55D6E8)
    val Green = Color(0xFF54D69A)
    val Red = Color(0xFFFF6B78)
    val Amber = Color(0xFFFFC46B)
    val BorderGlow = Color(0x559B7BFF)
    val BorderSubtle = Color(0x333B4260)
    val TextPrimary = Color(0xFFF4F2FF)
    val TextSecondary = Color(0xFFB7B4C9)
    val TextDisabled = Color(0xFF77758B)
}

private val JarvisDarkColors = darkColorScheme(
    primary = VoidColor.Violet,
    secondary = VoidColor.Cyan,
    background = VoidColor.Void950,
    surface = VoidColor.Void900,
    onPrimary = Color.White,
    onSecondary = VoidColor.Void950,
    onBackground = VoidColor.TextPrimary,
    onSurface = VoidColor.TextPrimary,
    error = VoidColor.Red
)

@Composable
fun OpenJarvisTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = JarvisDarkColors,
        content = content
    )
}
