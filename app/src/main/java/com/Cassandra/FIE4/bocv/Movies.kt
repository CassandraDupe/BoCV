package com.Cassandra.FIE4.bocv

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Movies(windowClass : WindowSizeClass, navController: NavController, viewModel : MainViewModel) {
    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Scaffold(
                topBar = {
                    TopNavBar(navController)
                },
                bottomBar = {
                    BottomNavBar(navController, personsBool = true)
                }
            ){
                val modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)
                buttonRetour(navController)
                afficherFilms(viewModel)
            }
        } else -> {
        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            buttonRetour(navController)
            afficherFilms(viewModel)
        }
    }


    }
}

@Composable
fun buttonRetour(navController : NavController){
    IconButton(onClick = { navController.navigate("Home") }, Modifier.size(75.dp)) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,) {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "home to go back to first page"
            )
            Text(text = "Films", fontSize = 10.sp)
        }
    }
}

@Composable
fun afficherFilms(viewModel : MainViewModel){
    val movies by viewModel.movies.collectAsState()

    if (movies.isEmpty()) viewModel.tendanceMovies()
     LazyColumn{
         items(movies){
             movie -> CardFilm(movie)
         }
     }
}

@Composable
fun CardFilm(mov: Movie, /*navController: NavController*/) {
    MyCard(
        route = "filmDetail/" + mov.id,
        chemin_img = mov.poster_path,
        titre = mov.title,
        date = mov.release_date/*,
        navController = navController*/
    )
}