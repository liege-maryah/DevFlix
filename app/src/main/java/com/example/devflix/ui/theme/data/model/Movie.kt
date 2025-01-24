package com.example.devflix.ui.theme.data.model

import com.google.gson.annotations.SerializedName

internal data class Movie(
    @SerializedName("Title") val title: String?,
    @SerializedName("Year") val year: String?,
    @SerializedName("imdbID")val imdbID: String?,
    @SerializedName("Type") val type: String?,
    @SerializedName("Poster")val poster: String?
)
