package com.example.devflix.ui.theme.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.devflix.R
import com.example.devflix.databinding.FragmentMovieItemListBinding
import com.example.devflix.ui.theme.data.model.Movie

internal class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = FragmentMovieItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(newMovies: List<Movie>) {
        this.movies = newMovies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: FragmentMovieItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            binding.yearTextView.text = movie.year
            binding.genreTextView.text = movie.type

            Glide.with(binding.root.context)
                .load(movie.poster)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.erro) 
                .into(binding.posterImageView)
        }
    }
}