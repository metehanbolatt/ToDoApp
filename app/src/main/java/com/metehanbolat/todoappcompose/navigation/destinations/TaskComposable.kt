package com.metehanbolat.todoappcompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.metehanbolat.todoappcompose.ui.screens.task.TaskScreen
import com.metehanbolat.todoappcompose.ui.viewmodels.SharedViewModel
import com.metehanbolat.todoappcompose.util.Action
import com.metehanbolat.todoappcompose.util.Constants.TASK_ARGUMENT_KEY
import com.metehanbolat.todoappcompose.util.Constants.TASK_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        }),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(
                    durationMillis = 400
                )
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(
                    durationMillis = 400
                )
            )
        }
    ){ navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId){
            sharedViewModel.getSelectedTask(taskId = taskId)

        }
        val selectedTask by sharedViewModel.selectedTask.collectAsState()
        
        LaunchedEffect(key1 = selectedTask){
            if (selectedTask != null || taskId == -1){
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}