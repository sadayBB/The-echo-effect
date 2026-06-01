package com.moonlessstudio.theechoeffect.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val EchoDarkColorScheme = darkColorScheme(
    primary = EchoBlue,
    onPrimary = SoftWhite,
    background = MoonlessBlackBlue,
    onBackground = SoftWhite,
    surface = MoonlessPurple,
    onSurface = SoftWhite,
    surfaceVariant = SurfaceDark,
    onSurfaceVariant = SoftWhite
)

@Composable
fun TheEchoEffectTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EchoDarkColorScheme,
        typography = Typography,
        content = content
    )
}
