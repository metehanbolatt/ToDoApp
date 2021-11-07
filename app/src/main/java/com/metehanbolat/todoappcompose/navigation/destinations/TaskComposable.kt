package com.metehanbolat.todoappcompose.navigation.destinations

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.metehanbolat.todoappcompose.ui.screens.task.TaskScreen
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
    ){ navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        Log.d("TaskComposable", taskId.toString())

        TaskScreen(navigateToListScreen = navigateToListScreen)
    }
}