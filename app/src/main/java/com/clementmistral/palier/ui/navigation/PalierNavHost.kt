package com.clementmistral.palier.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.clementmistral.palier.ui.screens.HistoryScreen
import com.clementmistral.palier.ui.screens.SettingsScreen
import com.clementmistral.palier.ui.screens.SynthesisScreen
import com.clementmistral.palier.ui.screens.TodayScreen

@Composable
fun PalierNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Today.route,
        modifier = modifier
    ) {
        composable<TodayRoute> { TodayScreen() }
        composable<SynthesisRoute> { SynthesisScreen() }
        composable<HistoryRoute> { HistoryScreen() }
        composable<SettingsRoute> { SettingsScreen() }

    }
}