package com.example.moviesapp.common.presentation.poster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.FragmentPosterDialogBinding

class PosterDialogFragment :DialogFragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentPosterDialogBinding?= null

    private val vm: MoviePostersViewModel by viewModels(ownerProducer = { requireParentFragment() })
    private val safeArgs:PosterDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPosterDialogBinding.inflate(layoutInflater,container,false)
//        loadPosters(safeArgs.path)
//        observePoster()
        return binding.root
    }

    private fun observePoster(){
        vm.poster.observe(viewLifecycleOwner){ poster ->
            binding.dialogPoster.setImage(ApiConstants.IMG_URL + poster)
        }
    }

    private fun loadPosters(path:String){
        vm.loadPoster(path)
    }

}