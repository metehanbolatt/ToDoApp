package com.metehanbolat.todoappcompose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.metehanbolat.todoappcompose.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = {}
    )
}