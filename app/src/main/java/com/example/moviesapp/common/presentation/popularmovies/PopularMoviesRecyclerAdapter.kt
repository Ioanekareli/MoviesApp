package com.example.moviesapp.common.presentation.popularmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.popularmovies.PopularMoviesDetails
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.PopularMoviesRecyclerItemBinding
import java.text.SimpleDateFormat
import javax.inject.Inject

class PopularMoviesRecyclerAdapter @Inject constructor(
    private val onClick: (movieId:Int) -> Unit
) :RecyclerView.Adapter<PopularMoviesRecyclerAdapter.ViewHolder>(){

    private val popularMovies = mutableListOf<PopularMoviesDetails>()

    inner class ViewHolder(private val binding:PopularMoviesRecyclerItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun onBind(position:Int){
            val model = popularMovies[position]
            with(binding){
                movieTitle.text = model.title
                releaseDate.text = model.releaseData.replace("-"," ")
                moviePoster.setImage(ApiConstants.IMG_URL + model.posterPath)
                itemView.setOnClickListener {
                    model.id.let { movieId -> onClick.invoke(movieId) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PopularMoviesRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = popularMovies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setData(popularMovies:List<PopularMoviesDetails>){
        this.popularMovies.clear()
        this.popularMovies.addAll(popularMovies)
        notifyDataSetChanged()
    }

}