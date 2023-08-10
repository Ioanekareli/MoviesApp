package com.example.moviesapp.common.presentation.moviedetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.common.domain.model.box.Box
import com.example.moviesapp.databinding.BoxItemBinding
import javax.inject.Inject

class BoxAdapter @Inject constructor()
    :RecyclerView.Adapter<BoxAdapter.ViewHolder>(){

    private val box = mutableListOf<Box>()

    inner class ViewHolder(private val binding:BoxItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(position: Int){
               val model = box[position]
               with(binding){
                   imageView.setImageResource(model.img)
                   tv.text = model.title
                   boxLayout.setBackgroundResource(model.color)
               }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BoxItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = box.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    fun setData(box:List<Box>){
        this.box.clear()
        this.box.addAll(box)
        notifyDataSetChanged()
    }

}