package com.metehanbolat.todoappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.metehanbolat.todoappcompose.navigation.SetupNavigation
import com.metehanbolat.todoappcompose.ui.theme.ToDoAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppComposeTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}
