package com.Cassandra.FIE4.bocv

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {
    @GET("search/movie")
    suspend fun getFilmsParMotCle(@Query("api_key") api_key : String, @Query("query") motCle : String) : TmdbResult

    @GET("trending/movie/week")
    suspend fun getFilmTendance(@Query("api_key") api_key : String) : TmdbResult
}