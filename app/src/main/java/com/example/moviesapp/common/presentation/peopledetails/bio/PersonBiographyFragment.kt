package com.example.moviesapp.common.presentation.peopledetails.bio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviesapp.R
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.presentation.peopledetails.PeopleDetailsViewModel
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.FragmentPersonBiographyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonBiographyFragment : Fragment(R.layout.fragment_person_biography) {

    private val binding get() = _binding!!
    private var _binding:FragmentPersonBiographyBinding?=null

    private val vm:PeopleDetailsViewModel by viewModels(ownerProducer = {requireParentFragment()})
//    private val safeArgs:PeopleDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonBiographyBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        loadPersonDetails(vm.personId.value!!)
        initListeners()
    }

    private fun initListeners() {
    }

    private fun setUpUI() {
        observePersonBio()
    }

    private fun observePersonBio() {
        vm.personDetails.observe(viewLifecycleOwner){personDetails ->
            when(personDetails){
                is Resource.Success -> {
                    with(binding){
                        personImg.setImage(ApiConstants.IMG_URL + personDetails.data.profile)
                        personName.text = personDetails.data.name
                        birthDayTv.text = personDetails.data.birthday
                        if (personDetails.data.deathDay.isNotEmpty())
                            deathTv.text = personDetails.data.deathDay
                        else
                            death.isVisible = false
                        knownForTv.text = personDetails.data.knownFor
                        biographyTv.text = personDetails.data.biography
                    }
                }else -> {

                }
            }
        }
    }

    private fun loadPersonDetails(personId: Int) {
        vm.loadPersonDetails(personId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}