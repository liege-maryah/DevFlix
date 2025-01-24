package com.example.devflix.ui.theme.ui.movie

import MovieViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devflix.R
import com.example.devflix.databinding.FragmentMovieListBinding
import com.example.devflix.ui.theme.ui.adapter.MovieAdapter
import com.example.devflix.ui.theme.ui.adapter.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModel()
    private val movieAdapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeMovies()
        observeErrors()

        viewModel.fetchMovies("Inception", "3db2c98c")
    }

    private fun setupRecyclerView() {
        binding.rvMovies.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context)
            val space = resources.getDimensionPixelSize(R.dimen.item_space)
            addItemDecoration(SpaceItemDecoration(space))
        }
    }

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            movieAdapter.updateMovies(movies)
        }
    }

    private fun observeErrors() {
        viewModel.error.observe(viewLifecycleOwner) { error ->
            Log.e("MovieListFragment", "Erro ao buscar filmes")
            Toast.makeText(requireContext(), "Erro ao carregar filmes", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
