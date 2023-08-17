package com.example.moviesapp.common.presentation.popularpeople

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.popularpeople.PopularPeopleDetails
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.PopularPeopleRecyclerItemBinding
import javax.inject.Inject

class PopularPeopleRecyclerAdapter @Inject constructor(
    private val onCLick:(movieId:Int) -> Unit
):RecyclerView.Adapter<PopularPeopleRecyclerAdapter.ViewHolder>() {

    private val popularPeople = mutableListOf<PopularPeopleDetails>()

    inner class ViewHolder(private val binding:PopularPeopleRecyclerItemBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(position:Int){
                val model = popularPeople[position]
                if (model.profile.isNotEmpty()) {
                    binding.peopleImg.setImage(ApiConstants.IMG_URL + model.profile)
                }
                binding.peopleImg.setOnClickListener {
                    model.id.let {personId -> onCLick.invoke(personId)}
                }
                binding.peopleName.text = model.name
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PopularPeopleRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = popularPeople.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    fun setData(popularPeople:List<PopularPeopleDetails>){
        this.popularPeople.clear()
        this.popularPeople.addAll(popularPeople)
        notifyDataSetChanged()
    }

}