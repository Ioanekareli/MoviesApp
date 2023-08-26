package com.example.moviesapp.common.presentation.poster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.databinding.FragmentMoviePostersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviePostersFragment : Fragment(R.layout.fragment_movie_posters) {

    private val binding get() = _binding!!
    private var _binding:FragmentMoviePostersBinding ?= null

    private val vm:MoviePostersViewModel by viewModels()
    private val safeArgs:MoviePostersFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviePostersBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initListeners()
        setupUI()
        loadPosters(safeArgs.id)
    }

    private fun initListeners() {
        binding.postersRecycler.setOnClickListener {
            showPosterDialog()
        }
    }

    private fun setupUI(){
        val adapter = createPostersAdapter()
        initRecyclerView(adapter)
        observeMoviePosters(adapter)
    }

    private fun createPostersAdapter(): MoviePostersAdapter {
        return MoviePostersAdapter(::onPosterClick)
    }

    private fun onPosterClick(path:String){
        val bundle = bundleOf("path" to path )
        findNavController().navigate(R.id.posterDialogFragment,bundle)
    }

    private fun showPosterDialog(){
        PosterDialogFragment().show(childFragmentManager,"poster")
    }

    private fun initRecyclerView(
        postersAdapter: MoviePostersAdapter
    ){
        binding.postersRecycler.apply {
            adapter = postersAdapter
            layoutManager = GridLayoutManager(requireContext(),3)
            setHasFixedSize(true)
        }
    }

    private fun observeMoviePosters(adapter: MoviePostersAdapter) {
        vm.moviePoster.observe(viewLifecycleOwner){ moviePosters ->
            when(moviePosters){
                is Resource.Success -> {
                    adapter.setData(moviePosters.data.posters)
                }else -> {

                }
            }
        }
    }

    private fun loadPosters(movieId:Int){
        vm.loadPosters(movieId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}