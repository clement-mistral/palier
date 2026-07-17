package com.clementmistral.palier.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Today
import androidx.compose.material.icons.outlined.Insights
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination (
    val route: TopLevelRoute,
    val label: String,
    val icon: ImageVector
) {
    Today(TodayRoute, "Aujourd'hui", Icons.Outlined.Today),
    Synthesis(SynthesisRoute, "Synthèse", Icons.Outlined.Insights),
    History(HistoryRoute, "Historique", Icons.Outlined.History),
    Settings(SettingsRoute, "Réglages", Icons.Outlined.Settings)
}