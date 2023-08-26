package com.example.moviesapp.common.presentation.poster

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.movieposters.Posters
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.PostersRecyclerItemBinding
import javax.inject.Inject

class MoviePostersAdapter @Inject constructor(
    private val onClick:( path:String ) -> Unit
):RecyclerView.Adapter<MoviePostersAdapter.ViewHolder>() {

    private val moviePosters = mutableListOf<Posters>()

    inner class ViewHolder(private val binding:PostersRecyclerItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(position:Int){
                val model = moviePosters[position]
                if (model.filePath.isNotEmpty()){
                    binding.poster.setImage(ApiConstants.IMG_URL + model.filePath)
                }
                itemView.setOnClickListener {
                    model.filePath.let {path-> onClick.invoke(path)}
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePostersAdapter.ViewHolder {
        return ViewHolder(
            PostersRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = moviePosters.size

    override fun onBindViewHolder(holder: MoviePostersAdapter.ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    fun setData(moviePosters:List<Posters>){
        this.moviePosters.clear()
        this.moviePosters.addAll(moviePosters)
        notifyDataSetChanged()
    }

}