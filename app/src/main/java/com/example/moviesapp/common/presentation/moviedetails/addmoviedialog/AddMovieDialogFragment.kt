package com.example.moviesapp.common.presentation.moviedetails.addmoviedialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.common.data.db.entity.mymovies.MyMovieEntity
import com.example.moviesapp.common.presentation.moviedetails.MovieDetailsViewModel
import com.example.moviesapp.databinding.FragmentAddMovieDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddMovieDialogFragment : DialogFragment() {

    private var _binding: FragmentAddMovieDialogBinding ?= null
    private val binding get() = _binding!!

    private val safeArgs:AddMovieDialogFragmentArgs by navArgs()
    private val vm: MovieDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMovieDialogBinding.inflate(layoutInflater,container,false)
        onAddButtonCLick()
        return binding.root
    }

    private fun onAddButtonCLick(){
        binding.addBtn.setOnClickListener {
            vm.addMyMovie(
                MyMovieEntity.fromDomain(
                    movieId = safeArgs.movieId,
                    poster = vm.moviePoster.value.orEmpty(),
                    rating = binding.rateMovieBar.rating
                )
            )
            Toast.makeText(requireContext(), "Movie added to database", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
