package com.example.moviesapp.common.presentation.mymovies

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.data.db.entity.mymovies.MyMovieEntity
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.MyMoviesRecyclerItemBinding
import javax.inject.Inject

class MyMoviesAdapter @Inject constructor(
    private val onClick: (movieId: Int) -> Unit,
    private val onLongClick: (movieId: Int) -> Unit
) : RecyclerView.Adapter<MyMoviesAdapter.ViewHolder>() {

    private val myMovies = mutableListOf<MyMovieEntity>()

    inner class ViewHolder(private val binding: MyMoviesRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val model = myMovies[position]
            with(binding) {
                rate.rating = model.rating ?: 0f
                moviePoster.setImage(ApiConstants.IMG_URL + model.posterPath)
                itemView.setOnClickListener {
                    model.id.let { movieId -> onClick.invoke(movieId) }
                }
            }

            itemView.setOnLongClickListener {
                val itemPosition = adapterPosition
                if (itemPosition != RecyclerView.NO_POSITION) {
                    val builder = AlertDialog.Builder(itemView.context)
                    builder.setTitle("Delete")
                        .setMessage("Do you want to delete this item?")
                        .setPositiveButton("Yes") { dialog, which ->
                            if (itemPosition < myMovies.size) {
                                val deletedItemId = myMovies[itemPosition].id
                                myMovies.removeAt(itemPosition)
                                notifyItemRemoved(itemPosition)
                                onLongClick.invoke(deletedItemId)
                            }
                        }
                        .setNegativeButton("No") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MyMoviesRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = myMovies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setData(myMovies: List<MyMovieEntity>) {
        this.myMovies.clear()
        this.myMovies.addAll(myMovies)
        notifyDataSetChanged()
    }
}
