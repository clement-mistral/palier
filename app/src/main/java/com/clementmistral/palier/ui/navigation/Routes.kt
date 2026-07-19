package com.clementmistral.palier.ui.navigation

import kotlinx.serialization.Serializable

sealed interface TopLevelRoute

@Serializable data object TodayRoute : TopLevelRoute
@Serializable data object SynthesisRoute : TopLevelRoute
@Serializable data object HistoryRoute : TopLevelRoute
@Serializable data object SettingsRoute : TopLevelRoute
@Serializable data object TreatmentsRoute : TopLevelRoute
@Serializable data object RemindersRoute : TopLevelRoute