package com.example.moviesapp.common.presentation.toprated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.topratedmovies.TopRatedMoviesList
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.SimilarMoviesRecyclerItemBinding
import javax.inject.Inject

class TopRatedMoviesAdapter @Inject constructor(
    private val onCLick:(movieId:Int) -> Unit
):RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder>() {

    private val topRatedMovies = mutableListOf<TopRatedMoviesList>()

    inner class ViewHolder(private val binding:SimilarMoviesRecyclerItemBinding)
        :RecyclerView.ViewHolder(binding.root){

            fun onBind(position:Int){
                val model = topRatedMovies[position]
                if (model.poster.isNotEmpty())
                    binding.img.setImage(ApiConstants.IMG_URL + model.poster)
                binding.img.setOnClickListener {
                    model.id.let { movieId -> onCLick.invoke(movieId)}
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

    override fun getItemCount() = topRatedMovies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    fun setData(topRatedMovies:List<TopRatedMoviesList>){
        this.topRatedMovies.clear()
        this.topRatedMovies.addAll(topRatedMovies)
        notifyDataSetChanged()
    }

}