package com.example.moviesapp.common.presentation.peopledetails.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.personmovies.MoviesAsCrew
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.SingleMovieImgItemBinding
import javax.inject.Inject

class CrewMoviesAdapter @Inject constructor(

): RecyclerView.Adapter<CrewMoviesAdapter.ViewHolder>() {

    private val crewMovies = mutableListOf<MoviesAsCrew>()

    inner class ViewHolder(private val binding: SingleMovieImgItemBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(position:Int){
            val model = crewMovies[position]
            if (model.profile.isNotEmpty())
                binding.img.setImage(ApiConstants.IMG_URL + model.profile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewMoviesAdapter.ViewHolder {
        return ViewHolder(
            SingleMovieImgItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CrewMoviesAdapter.ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    override fun getItemCount() = crewMovies.size

    fun setData(crewMovies:List<MoviesAsCrew>){
        this.crewMovies.clear()
        this.crewMovies.addAll(crewMovies)
        notifyDataSetChanged()
    }

}