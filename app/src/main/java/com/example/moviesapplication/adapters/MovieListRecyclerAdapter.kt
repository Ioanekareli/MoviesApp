package com.example.moviesapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapplication.databinding.MoviesListItemBinding
import com.example.moviesapplication.dto.Result
import com.example.moviesapplication.dto.TopRatedMovieList
import com.example.moviesapplication.utils.setImage

class MovieListRecyclerAdapter(private var movieItemsList:TopRatedMovieList,private val onMovieClick: (model:Result) -> Unit):RecyclerView.Adapter<MovieListRecyclerAdapter.ViewHolder>() {

    class ViewHolder(private val binding: MoviesListItemBinding):RecyclerView.ViewHolder(binding.root){
        val movieImage = binding.movieImage
        val movieTitle = binding.movieTitle
        val movieOverView = binding.movieOverview
        val movieRating = binding.movieRating
        val movieBudget = binding.movieBudget
        val movieGenre = binding.movieGenre
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MoviesListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItems = movieItemsList.results[position]
        holder.movieImage.setImage(movieItems.backdropPath)
        holder.movieTitle.text = movieItems.title
        holder.movieOverView.text = movieItems.overview
        holder.movieRating.text = movieItems.popularity.toString()
        holder.itemView.setOnClickListener {
            onMovieClick.invoke(movieItems)
        }
    }

    override fun getItemCount() = movieItemsList.results.size


}