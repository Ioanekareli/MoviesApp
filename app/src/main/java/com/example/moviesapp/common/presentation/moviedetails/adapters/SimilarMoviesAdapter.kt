package com.example.moviesapp.common.presentation.moviedetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMoviesDetails
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.SingleMovieImgItemBinding
import javax.inject.Inject

class SimilarMoviesAdapter @Inject constructor(
    private val onClick:(movieId:Int) -> Unit
)
    :RecyclerView.Adapter<SimilarMoviesAdapter.ViewHolder>(){

    private val similarMovies = mutableListOf<SimilarMoviesDetails>()

    inner class ViewHolder(private val binding:SingleMovieImgItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(position: Int){
                val model = similarMovies[position]
                with(binding){
                    if (model.posterPath.isNotEmpty())
                        img.setImage(ApiConstants.IMG_URL + model.posterPath)
                    itemView.setOnClickListener {
                        model.id.let { movieId -> onClick.invoke(movieId) }
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SingleMovieImgItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = similarMovies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    fun setData(similarMovies:List<SimilarMoviesDetails>){
        this.similarMovies.clear()
        this.similarMovies.addAll(similarMovies)
        notifyDataSetChanged()
    }

}