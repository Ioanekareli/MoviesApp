package com.example.moviesapp.common.presentation.peopledetails.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.presentation.peopledetails.PeopleDetailsViewModel
import com.example.moviesapp.common.presentation.peopledetails.movies.adapters.CastMoviesAdapter
import com.example.moviesapp.common.presentation.peopledetails.movies.adapters.CrewMoviesAdapter
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.databinding.FragmentPersonMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonMoviesFragment : Fragment(R.layout.fragment_person_movies) {

    private val binding get() = _binding!!
    private var _binding: FragmentPersonMoviesBinding?=null

    private val vm: PeopleDetailsViewModel by viewModels(ownerProducer = {requireParentFragment()})

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        loadPersonMovies(vm.personId.value!!)
    }

    private fun initListeners(){

    }

    private fun setUpUI(){
        val castAdapter = createCastMoviesAdapter()
        val crewAdapter = createCrewMoviesAdapter()
        initCastMoviesRecyclerView(castAdapter)
        initCrewMoviesRecyclerView(crewAdapter)
        observePersonMovies(crewAdapter, castAdapter)
    }

    private fun createCrewMoviesAdapter(): CrewMoviesAdapter {
        return CrewMoviesAdapter()
    }

    private fun createCastMoviesAdapter(): CastMoviesAdapter {
        return CastMoviesAdapter()
    }

    private fun initCastMoviesRecyclerView(
        castAdapter:CastMoviesAdapter
    ){
        binding.personCastMoviesRecycler.apply {
            adapter = castAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun initCrewMoviesRecyclerView(
        crewAdapter: CrewMoviesAdapter
    ){
        binding.personCrewMoviesRecycler.apply {
            adapter = crewAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun observePersonMovies(
        crewAdapter: CrewMoviesAdapter,
        castAdapter: CastMoviesAdapter
    ){
        vm.personMovies.observe(viewLifecycleOwner){personMovies ->
            when(personMovies){
                is Resource.Success -> {
                    crewAdapter.setData(personMovies.data.crew)
                    castAdapter.setData(personMovies.data.cast)
                }
                else ->{

                }
            }
        }
    }

    private fun loadPersonMovies(personId:Int){
        vm.loadPersonMovies(personId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}