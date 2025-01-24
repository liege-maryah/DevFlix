package com.example.devflix.ui.theme.domain.usecase

import MovieRepository
import com.example.devflix.ui.theme.data.model.Movie

internal class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(search: String, apiKey: String): List<Movie> {
        val result = movieRepository.getMoviesFromApi(search, apiKey)
        return result.getOrNull() ?: emptyList()
    }
}


