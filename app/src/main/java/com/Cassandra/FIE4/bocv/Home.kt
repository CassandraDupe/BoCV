package com.Cassandra.FIE4.bocv

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(windowClass : WindowSizeClass, navController: NavController){


    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {


                BlockPhoto()
                BlockDescr()
                BlockReseau()
                Button(navController)
            }
        }
        else -> {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically){
                BlockPhoto()
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    BlockDescr()
                    BlockReseau()
                    Button(navController)
                }
            }
        }
    }
}

@Composable
fun BlockPhoto(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.bernard),
            contentDescription = "Le magnifique Bernard Werber",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(250.dp)

        )
        Text(
            text = "Bernard Werber",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
        )
    }
}


@Composable
fun BlockReseau(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Row(){
            Image(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "logo email",
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "werbernard@gmail.com",
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
            )
        }

        Spacer(modifier = Modifier.size(10.dp))

        Row(){
            Image(
                painter = painterResource(id = R.drawable.instagram_png),
                contentDescription = "logo insta",
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "werbernard",
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
            )
        }
    }
}

@Composable
fun BlockDescr(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Très séduisant auteur renommé d'un genre littéraire imaginé par lui-même, la philosophie-fiction",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
        )
    }
}

@Composable
fun Button(navController : NavController){
    androidx.compose.material3.Button(onClick = {navController.navigate("Films")}) {
        Text("Démarrer")
    }
}