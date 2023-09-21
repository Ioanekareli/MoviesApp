package com.example.moviesapp.common.presentation.peopledetails.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.personmovies.MoviesAsCast
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.SingleMovieImgItemBinding
import javax.inject.Inject

class CastMoviesAdapter @Inject constructor(
    
):RecyclerView.Adapter<CastMoviesAdapter.ViewHolder>() {
    
    private val castMovies = mutableListOf<MoviesAsCast>()
    
    inner class ViewHolder(private val binding:SingleMovieImgItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            
            fun onBind(position:Int){
                val model = castMovies[position]
                if (model.profile.isNotEmpty())
                    binding.img.setImage(ApiConstants.IMG_URL + model.profile)
            }
            
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastMoviesAdapter.ViewHolder {
        return ViewHolder(
            SingleMovieImgItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CastMoviesAdapter.ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    override fun getItemCount() = castMovies.size

    fun setData(castMovies:List<MoviesAsCast>){
        this.castMovies.clear()
        this.castMovies.addAll(castMovies)
        notifyDataSetChanged()
    }
    
}