package com.metehanbolat.todoappcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.metehanbolat.todoappcompose.util.Action
import com.metehanbolat.todoappcompose.util.Constants
import com.metehanbolat.todoappcompose.util.Constants.TASK_ARGUMENT_KEY
import com.metehanbolat.todoappcompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }
}