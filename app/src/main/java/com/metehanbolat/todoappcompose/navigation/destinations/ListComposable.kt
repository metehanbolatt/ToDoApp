package com.metehanbolat.todoappcompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.metehanbolat.todoappcompose.ui.screens.list.ListScreen
import com.metehanbolat.todoappcompose.ui.viewmodels.SharedViewModel
import com.metehanbolat.todoappcompose.util.Action
import com.metehanbolat.todoappcompose.util.Constants.LIST_ARGUMENT_KEY
import com.metehanbolat.todoappcompose.util.Constants.LIST_SCREEN
import com.metehanbolat.todoappcompose.util.toAction

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        }),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(
                    durationMillis = 400
                )
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(
                    durationMillis = 400
                )
            )
        }
    ){ navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        var myAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = myAction){
            if (action != myAction){
                myAction = action
                sharedViewModel.action.value = action
            }
        }

        val databaseAction by sharedViewModel.action

        ListScreen(
            action = databaseAction,
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}