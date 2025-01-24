package com.example.devflix.ui.theme.data.api

import com.example.devflix.ui.theme.data.model.MovieSearchResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {
    @GET("/")
    suspend fun getMovies(
        @Query("s") searchTerm: String,
        @Query("apikey") apiKey: String
    ): retrofit2.Response<MovieSearchResponse>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}

