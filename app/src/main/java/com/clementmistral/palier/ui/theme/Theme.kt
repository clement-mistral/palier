package com.clementmistral.palier.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val PalierColorScheme = darkColorScheme(
    primary = SlateBlue,
    onPrimary = Ink900,
    background = Ink900,
    onBackground = Bone100,
    surface = Ink800,              // cartes standard
    onSurface = Bone100,
    surfaceVariant = Ink850,       // cartes surélevées
    onSurfaceVariant = Gray400,    // texte secondaire
    outline = Gray500,
    inverseSurface = Bone100,      // badges clairs
    inverseOnSurface = Ink900,
)

@Composable
fun PalierTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = PalierColorScheme,
        typography = Typography,
        content = content
    )
}