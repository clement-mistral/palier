package com.clementmistral.palier.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.clementmistral.palier.ui.screens.HistoryScreen
import com.clementmistral.palier.ui.screens.ReminderScreen
import com.clementmistral.palier.ui.screens.SettingsScreen
import com.clementmistral.palier.ui.screens.SynthesisScreen
import com.clementmistral.palier.ui.screens.TodayScreen
import com.clementmistral.palier.ui.screens.TreatmentsScreen

@Composable
fun PalierNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavDestination.Today.route,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable<TodayRoute> { TodayScreen() }
        composable<SynthesisRoute> { SynthesisScreen() }
        composable<HistoryRoute> { HistoryScreen() }
        composable<SettingsRoute> { SettingsScreen(
            onTreatmentClick = { navController.navigate(TreatmentsRoute) },
            onReminderClick = { navController.navigate(RemindersRoute) }
        ) }


        // Settings routes
        composable<TreatmentsRoute>(
            enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it / 4 }, animationSpec = tween(300)) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it / 4 }, animationSpec = tween(300)) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300)) }
        ) { TreatmentsScreen(onBack = {navController.navigateUp()}) }
        composable<RemindersRoute>(enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it / 4 }, animationSpec = tween(300)) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it / 4 }, animationSpec = tween(300)) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300)) }) { ReminderScreen(onBack = {navController.navigateUp()}) }
    }
}