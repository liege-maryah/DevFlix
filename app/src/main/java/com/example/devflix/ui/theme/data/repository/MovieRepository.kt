import com.example.devflix.ui.theme.data.api.ApiService
import com.example.devflix.ui.theme.data.model.Movie

internal class MovieRepository(
    private val apiService: ApiService,

    ) {
    suspend fun getMoviesFromApi(search: String, apiKey: String): Result<List<Movie>> {
        return try {
            val response = apiService.getMovies(search, apiKey)
            if (response.isSuccessful) {
                val movieSearchResponse = response.body()
                if (movieSearchResponse?.movies != null && movieSearchResponse.movies.isNotEmpty()) {
                    Result.success(movieSearchResponse.movies)
                } else {
                    Result.failure(Exception("Nenhum filme encontrado."))
                }
            } else {
                Result.failure(Exception("Erro na resposta da API: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

