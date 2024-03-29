package com.example.moviesapp.common.presentation.moviedetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.castcrew.Crew
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.CrewRecyclerItemBinding
import javax.inject.Inject

class CrewAdapter @Inject constructor(
    private val onClick:(personId:Int) -> Unit
):RecyclerView.Adapter<CrewAdapter.ViewHolder>() {

    private val crew = mutableListOf<Crew>()

    inner class ViewHolder(private val binding: CrewRecyclerItemBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(position:Int){
            val model = crew[position]
            with(binding){
                if (model.profile.isNotEmpty())
                    crewPic.setImage(ApiConstants.IMG_URL + model.profile)
                else
                    crewPic.setImageResource(R.drawable.person_icon)
                crewName.text= model.name
                job.text = model.job
                itemView.setOnClickListener {
                    model.id.let { personId -> onClick.invoke(personId) }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CrewRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    override fun getItemCount() = crew.size

    fun setData(crew:List<Crew>){
        this.crew.clear()
        this.crew.addAll(crew)
        notifyDataSetChanged()
    }

}