package com.example.moviesapp.common.presentation.popularmovies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.NoMoreMoviesException
import com.example.moviesapp.databinding.FragmentPopularMoviesBinding
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
        requestPopularMoviesList()
    }

    private fun setupUI(){
        val adapter = createAdapter()
        initRecyclerView(adapter)
        observerViewStateUpdates(adapter)
    }

    private fun createAdapter():PopularMoviesRecyclerAdapter{
        return PopularMoviesRecyclerAdapter()
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

    private fun observerViewStateUpdates(adapter: PopularMoviesRecyclerAdapter){
        viewModel.state.observe(viewLifecycleOwner){
            updateScreenState(it,adapter)
            Log.d("logkata", "observerViewStateUpdates: $it ")
        }
    }

    private fun updateScreenState(state: PopularMoviesViewState,adapter: PopularMoviesRecyclerAdapter){
        binding.progressBar.isVisible = state.loading
        adapter.setData(state.popularMovies)
        Log.d("logkata", "updateScreenState: ${state.popularMovies} ")
        noMoreMovies(state.noMorePopularMovies)
    }

    private fun noMoreMovies(noMoreMovies:Boolean){
        val message = "There is no more movies"
        if(noMoreMovies){
           throw NoMoreMoviesException(message)
        }
    }

    private fun requestPopularMoviesList(){
        viewModel.onEvent(PopularMoviesEvent.RequestPopularMoviesList,ApiConstants.API_KEY,ApiConstants.PAGE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
