package com.metehanbolat.todoappcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.metehanbolat.todoappcompose.ui.screens.splash.SplashScreen
import com.metehanbolat.todoappcompose.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToTaskScreen: () -> Unit,
){
    composable(
        route = SPLASH_SCREEN,
    ){
        SplashScreen(navigateToListScreen = navigateToTaskScreen)
    }
}