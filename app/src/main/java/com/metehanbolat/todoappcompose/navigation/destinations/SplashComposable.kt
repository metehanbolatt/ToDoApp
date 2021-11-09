package com.metehanbolat.todoappcompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.metehanbolat.todoappcompose.ui.screens.splash.SplashScreen
import com.metehanbolat.todoappcompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToTaskScreen: () -> Unit,
){
    composable(
        route = SPLASH_SCREEN,
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(400)
            )
        }
    ){
        SplashScreen(navigateToListScreen = navigateToTaskScreen)
    }
}