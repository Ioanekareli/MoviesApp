package com.example.moviesapp.common.presentation.mymovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMyMoviesBinding

class MyMoviesFragment : Fragment(R.layout.fragment_my_movies) {

    private val binding get() = _binding!!
    private var _binding: FragmentMyMoviesBinding?=null

    private val vm: MyMoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadMyMovies()
        initListeners()
        setUpUI()
    }

    private fun initListeners() {
        binding.appBar.backButton.setOnClickListener {
            navigateBacK()
        }
    }

    private fun navigateBacK(){
        findNavController().popBackStack()
    }

    private fun setUpUI() {
        val adapter = createAdapter()
        initRecyclerView(adapter)
        observeMyMovies(adapter)
    }

    private fun createAdapter():MyMoviesAdapter{
        return MyMoviesAdapter(::onMovieCLick,::onLongClick)
    }

    private fun onMovieCLick(movieId:Int){
        val bundle = bundleOf("id" to movieId)
        findNavController().navigate(R.id.movieDetailsFragment,bundle)
    }

    private fun onLongClick(movieId: Int){
        vm.deleteMovie(movieId)
    }

    private fun initRecyclerView(
        myMoviesAdapter: MyMoviesAdapter
    ){
        binding.myMoviesRecycler.apply {
            adapter = myMoviesAdapter
            layoutManager = GridLayoutManager(requireContext(),4)
        }
    }

    private fun observeMyMovies(adapter: MyMoviesAdapter){
        vm.myMovies.observe(viewLifecycleOwner){ myMovies ->
            adapter.setData(myMovies)
        }
    }

    private fun loadMyMovies() {
        vm.loadMyMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}