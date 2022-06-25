package com.example.moviesapplication.ui.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapplication.MoviesViewModelProvider
import com.example.moviesapplication.R
import com.example.moviesapplication.adapters.MovieListRecyclerAdapter
import com.example.moviesapplication.databinding.FragmentMoviesListBinding
import com.example.moviesapplication.dto.Result
import com.example.moviesapplication.dto.TopRatedMovieList
import com.example.moviesapplication.repository.MoviesRepository
import com.example.moviesapplication.utils.Resource


class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    private lateinit var binding:FragmentMoviesListBinding
    private lateinit var adapter:MovieListRecyclerAdapter
    private lateinit var moviesListViewModel:MoviesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(inflater,container,false)

        val moviesRepository = MoviesRepository()
        val viewModelProvider = MoviesViewModelProvider(moviesRepository)
        moviesListViewModel = ViewModelProvider(this,viewModelProvider).get(MoviesListViewModel::class.java)
        moviesListViewModel.getMoviesList(api_key)
        observeMoviesList()
        return binding.root
    }

    companion object{
        const val api_key = "b2be7c6263d4844e6a6565c38e728c5f"
    }



    private fun observeMoviesList(){
        moviesListViewModel.movieList.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success ->{
                    initRecyclerView(response.data!!)
                }
                is Resource.Error ->{
                    response.message.let {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                    }
                }

                else -> {
                    response.message.let {
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun initRecyclerView(moviesList : TopRatedMovieList){
        binding.moviesListRecycler.layoutManager = LinearLayoutManager(requireContext())
        adapter = MovieListRecyclerAdapter(moviesList,::onMovieCLick)
        binding.moviesListRecycler.adapter = adapter
    }

    private fun onMovieCLick(model:Result){
        val action = MoviesListFragmentDirections.actionMoviesListFragmentToMoviesDetailFragment(model)
        findNavController().navigate(action)
    }

}