package com.Cassandra.FIE4.bocv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Cassandra.FIE4.bocv.ui.theme.BoCVTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3WindowSizeClassApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoCVTheme{
                val windowSizeClass = calculateWindowSizeClass(this)
                Screen(windowSizeClass, MainViewModel())
            }
        }
    }
}

@Composable
fun Screen(windowSizeClass : WindowSizeClass, viewModel : MainViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable("Home") {
            Home(windowSizeClass, navController)
        }
        composable("Films") {
            Movies(windowSizeClass, navController, viewModel)
        }
        composable("Serie") {
            Series(windowSizeClass, navController, viewModel)
        }
        composable("Actoeur") {
            Actors(windowSizeClass, navController, viewModel)
        }
    }
}