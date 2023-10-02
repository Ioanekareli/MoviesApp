package com.example.moviesapp.common.presentation.popularmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.databinding.FragmentPopularMoviesBinding
import com.example.moviesapp.databinding.SnackBarCustomLayoutBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding:FragmentPopularMoviesBinding?=null

    private val viewModel:PopularMoviesViewModel  by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadPopularMovies()
    }

    private fun setupUI(){
        val adapter = createAdapter()
        initRecyclerView(adapter)
        observeData(adapter)
    }

    private fun onClick(movieId:Int){
        val bundle = bundleOf("id" to movieId )
        findNavController().navigate(R.id.movieDetailsFragment,bundle)
    }

    private fun createAdapter():PopularMoviesRecyclerAdapter{
        return PopularMoviesRecyclerAdapter(::onClick)
    }

    private fun initRecyclerView(
        popularMoviesRecyclerAdapter: PopularMoviesRecyclerAdapter
    ){
        binding.popularMoviesRecycler.apply {
            adapter = popularMoviesRecyclerAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun observeData(adapter:PopularMoviesRecyclerAdapter){
        viewModel.popularMovies.observe(viewLifecycleOwner){
            when(it){
                is Resource.Success -> {
                    adapter.setData(it.data.results)
                    binding.progressBar.isVisible = false
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    showSnackBar()
                }
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }
                else -> {
                }
            }
        }
    }

    private fun loadPopularMovies(){
        viewModel.loadMovies()
    }

    private fun showSnackBar(){
        val customSnackBar = Snackbar.make(binding.root,"",Snackbar.LENGTH_LONG)
        val layout = customSnackBar.view as SnackbarLayout
        val bind = SnackBarCustomLayoutBinding.inflate(layoutInflater)
        layout.addView(bind.root,0)
        layout.setPadding(0,0,0,8)
        customSnackBar.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
