import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.devflix.ui.theme.data.model.Movie
import com.example.devflix.ui.theme.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

internal class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> get() = _error

    fun fetchMovies(search: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val movieList = getMoviesUseCase(search, apiKey)
                _movies.value = movieList
            } catch (e: Exception) {
                _error.value = e
                Log.e("MovieViewModel", "Erro ao buscar filmes", e)
            }
        }
    }
}




