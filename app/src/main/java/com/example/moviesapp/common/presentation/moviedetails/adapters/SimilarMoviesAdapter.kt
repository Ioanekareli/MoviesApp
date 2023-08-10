package com.example.moviesapp.common.presentation.moviedetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.castcrew.Cast
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMovies
import com.example.moviesapp.common.domain.model.similarmovies.SimilarMoviesDetails
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.CastRecyclerItemBinding
import com.example.moviesapp.databinding.SimilarMoviesRecyclerItemBinding
import javax.inject.Inject

class SimilarMoviesAdapter @Inject constructor()
    :RecyclerView.Adapter<SimilarMoviesAdapter.ViewHolder>(){

    private val similarMovies = mutableListOf<SimilarMoviesDetails>()

    inner class ViewHolder(private val binding:SimilarMoviesRecyclerItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(position: Int){
                val model = similarMovies[position]
                with(binding){
                    if (model.posterPath.isNotEmpty()){
                        img.setImage(ApiConstants.IMG_URL + model.posterPath)
                    }else{
                        img.setImageResource(R.drawable.image_icon)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SimilarMoviesRecyclerItemBinding.inflate(
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