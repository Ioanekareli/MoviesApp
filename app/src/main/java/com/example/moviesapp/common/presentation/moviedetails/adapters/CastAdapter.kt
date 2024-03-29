package com.example.moviesapp.common.presentation.moviedetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.castcrew.Cast
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.CastRecyclerItemBinding
import javax.inject.Inject

class CastAdapter @Inject constructor(
    private val onClick:(personId:Int) -> Unit
):RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    private val cast = mutableListOf<Cast>()

    inner class ViewHolder(private val binding:CastRecyclerItemBinding)
        :RecyclerView.ViewHolder(binding.root){

            fun onBind(position:Int){
                val model = cast[position]
                with(binding){
                    if (model.profile.isNotEmpty())
                        castPic.setImage(ApiConstants.IMG_URL + model.profile)
                    else
                        castPic.setImageResource(R.drawable.person_icon)
                    castName.text= model.name
                    character.text = model.character
                    itemView.setOnClickListener {
                        model.id.let { personId -> onClick.invoke(personId) }
                    }
                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CastRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.onBind(position)
    }

    override fun getItemCount() = cast.size

    fun setData(cast:List<Cast>){
        this.cast.clear()
        this.cast.addAll(cast)
        notifyDataSetChanged()
    }

}