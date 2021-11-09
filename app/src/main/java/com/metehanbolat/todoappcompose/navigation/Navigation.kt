package com.metehanbolat.todoappcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.metehanbolat.todoappcompose.navigation.destinations.listComposable
import com.metehanbolat.todoappcompose.navigation.destinations.splashComposable
import com.metehanbolat.todoappcompose.navigation.destinations.taskComposable
import com.metehanbolat.todoappcompose.ui.viewmodels.SharedViewModel
import com.metehanbolat.todoappcompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController){ Screens(navController = navController) }

    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(
            navigateToTaskScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
    }
}