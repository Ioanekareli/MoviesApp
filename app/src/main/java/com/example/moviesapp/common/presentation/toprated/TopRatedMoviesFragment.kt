package com.example.moviesapp.common.presentation.toprated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.databinding.FragmentTopRatedMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRatedMoviesFragment : Fragment(R.layout.fragment_top_rated_movies) {

    private val binding get() = _binding!!
    private var _binding: FragmentTopRatedMoviesBinding?=null

    private val vm:TopRatedMoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopRatedMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setupUI()
        loadTopRatedMovies()
    }

    private fun initListeners(){

    }

    private fun setupUI() {
        val adapter = createAdapter()
        initRecyclerView(adapter)
        observeTopRatedMovies(adapter)
    }

    private fun createAdapter():TopRatedMoviesAdapter{
        return TopRatedMoviesAdapter(::onCLick)
    }

    private fun onCLick(movieId:Int){
        val bundle = bundleOf("id" to movieId)
        findNavController().navigate(R.id.movieDetailsFragment,bundle)
    }

    private fun initRecyclerView(
        topRatedMoviesAdapter: TopRatedMoviesAdapter
    ){
        binding.topRatedMoviesRecycler.apply {
            adapter = topRatedMoviesAdapter
            layoutManager = GridLayoutManager(requireContext(),4)
        }
    }

    private fun loadTopRatedMovies(){
        vm.loadMovies()
    }

    private fun observeTopRatedMovies(adapter: TopRatedMoviesAdapter){
        vm.topRatedMovies.observe(viewLifecycleOwner){ topRatedMovies ->
            when(topRatedMovies){
                is Resource.Success -> {
                    adapter.setData(topRatedMovies.data.topRatedMoviesList)
                }
                is Resource.Error -> {

                }
                is Resource.Loading ->{

                }
                else ->{

                }
            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}