package com.example.devflix.ui.theme.data.model

import com.google.gson.annotations.SerializedName

internal data class MovieSearchResponse(
    @SerializedName("Search") val movies: List<Movie>,
    @SerializedName("totalResults") val totalResults: String,
    @SerializedName("Response") val response: String
)