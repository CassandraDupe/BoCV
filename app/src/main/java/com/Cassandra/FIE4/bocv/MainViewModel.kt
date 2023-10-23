package com.Cassandra.FIE4.bocv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<Movie>>(listOf())

    val apiKey = "5505777adf8b18cbee7f31097025bfb6"

    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI::class.java)


    fun searchMovies(motCle : String){
        viewModelScope.launch {
            movies.value = service.getFilmsParMotCle(apiKey, motCle).results
        }
    }

    fun tendanceMovies(){
        viewModelScope.launch{
            movies.value = service.getFilmTendance(apiKey).results
        }
    }
}