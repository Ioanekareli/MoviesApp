package com.example.moviesapp.common.presentation.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.domain.model.box.Box
import com.example.moviesapp.common.presentation.moviedetails.adapters.BoxAdapter
import com.example.moviesapp.common.presentation.moviedetails.adapters.CastAdapter
import com.example.moviesapp.common.presentation.moviedetails.adapters.CrewAdapter
import com.example.moviesapp.common.presentation.moviedetails.adapters.SimilarMoviesAdapter
import com.example.moviesapp.common.utils.Resource
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.FragmentMovieDetailsBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details){

    private val binding get() = _binding!!
    private var _binding: FragmentMovieDetailsBinding?=null

    private val viewModel: MovieDetailsViewModel by viewModels()
    private val safeArgs:MovieDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setupUI()
        loadMovieDetails()
        loadTrailer(safeArgs.id)
        loadCast(safeArgs.id)
        loadCrew(safeArgs.id)
        loadSimilarMovies(safeArgs.id)
//        setupYoutubePlayer()
    }

    private fun initListeners(){
        binding.backBtn.setOnClickListener {
            navigateBackStack()
        }

        binding.showMoreTv.setOnClickListener {
            showMore()
        }

        binding.movieOverview.setOnClickListener {
            showLess()
        }

    }

    private fun setupUI(){
        setUpCastUi()
        setUpCrewUi()
        setUpBoxUi()
        setUpSimilarMoviesUi()
        observeMovieDetails()
        observerTrailer()
    }

    private fun setUpCastUi(){
        val castAdapter = createCastAdapter()
        initCastRecyclerView(castAdapter)
        observeCast(castAdapter)
    }

    private fun setUpCrewUi(){
        val crewAdapter = createCrewAdapter()
        initCrewRecyclerView(crewAdapter)
        observeCrew(crewAdapter)
    }

    private fun setUpBoxUi(){
        val boxAdapter = createBoxAdapter()
        initBoxRecyclerView(boxAdapter)
        observeBox(boxAdapter)
    }

    private fun setUpSimilarMoviesUi(){
        val adapter = createSimilarMoviesAdapter()
        initSimilarMoviesRecyclerView(adapter)
        observeSimilarMovies(adapter)
    }

    private fun createCastAdapter():CastAdapter{
        return CastAdapter(::onCastClick)
    }

    private fun createCrewAdapter():CrewAdapter{
        return CrewAdapter(::onCrewClick)
    }

    private fun createBoxAdapter():BoxAdapter{
        return BoxAdapter(::onPosterClick)
    }

    private fun createSimilarMoviesAdapter():SimilarMoviesAdapter{
        return SimilarMoviesAdapter(::onMovieClick)
    }

    private fun onMovieClick(movieId: Int){
        val bundle = bundleOf("id" to movieId)
        findNavController().navigate(R.id.movieDetailsFragment,bundle)
    }

    private fun onCastClick(personId:Int){
        val bundle = bundleOf("id" to personId)
        findNavController().navigate(R.id.peopleDetailsFragment,bundle)
    }

    private fun onCrewClick(personId:Int){
        val bundle = bundleOf("id" to personId)
        findNavController().navigate(R.id.peopleDetailsFragment,bundle)
    }

    private fun onPosterClick(movieId: Int){
        val bundle = bundleOf("id" to movieId)
        findNavController().navigate(R.id.moviePostersFragment,bundle)
    }

    private fun initCastRecyclerView(
        castAdapter: CastAdapter
    ){
        binding.castRecycler.apply {
            adapter = castAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(false)
        }
    }

    private fun initCrewRecyclerView(
        crewAdapter: CrewAdapter
    ){
        binding.crewRecycler.apply {
            adapter = crewAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(false)
        }
    }

    private fun initBoxRecyclerView(
        boxAdapter: BoxAdapter
    ){
        binding.boxRecycler.apply {
            adapter = boxAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun initSimilarMoviesRecyclerView(
        similarMoviesAdapter: SimilarMoviesAdapter
    ){
        binding.similarMoviesRecycler.apply {
            adapter = similarMoviesAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun navigateBackStack(){
        findNavController().popBackStack()
    }

    private fun loadMovieDetails(){
        viewModel.loadMovieDetails(safeArgs.id)
    }

    private fun loadTrailer(movieId:Int){
        viewModel.getTrailer(movieId)
    }

    private fun loadCast(movieId: Int){
        viewModel.loadCredits(movieId)
    }

    private fun loadCrew(movieId: Int){
        viewModel.loadCredits(movieId)
    }

    private fun loadSimilarMovies(movieId: Int){
        viewModel.loadSimilarMovies(movieId)
    }

    private fun observeMovieDetails(){
        viewModel.movieDetails.observe(viewLifecycleOwner){ movieDetails ->
            when(movieDetails){
                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    with(binding){
                        moviePosterSmall.setImage(ApiConstants.IMG_URL + movieDetails.data.posterPath)
                        moviesPosterLarge.setImage(ApiConstants.IMG_URL + movieDetails.data.backdropPath)
                        movieTitle.text = movieDetails.data.title
                        runtime.text = movieDetails.data.runtime.toString()
                        budget.text = movieDetails.data.budget.toString()
                        binding.genres.text = movieDetails.data.genre.let { genreList ->
                            var res = ""
                            for(i in genreList){
                                res+=i.name + " "
                            }
                            res
                        }
                        binding.countries.text = movieDetails.data.countries.let { countryList ->
                            var res = ""
                            for (i in countryList){
                                res+=i.name + " "
                            }
                            res
                        }
                        movieOverview.text = movieDetails.data.overview
                    }
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    binding.errorText.isVisible = true
                }
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }

                else -> {

                }
            }
        }
    }

    private fun observerTrailer(){
        viewModel.trailer.observe(viewLifecycleOwner){ trailer ->
            when(trailer){
                is Resource.Success -> {
                    val list = trailer.data.results
                    for (i in list.indices){
                        if (list[i].type == TRAILER){
                            initYoutubePlayer(list[i].key)
                            break
                        }else if (i == list.lastIndex){
                            trailerNotAvailable()
                        }
                    }
                }
                is Resource.Error -> {
                    trailerNotAvailable()
                }
                else ->{
                    trailerNotAvailable()
                }
            }
        }
    }

    private fun observeCast(adapter: CastAdapter){
        viewModel.credits.observe(viewLifecycleOwner){ cast ->
            when(cast){
                is Resource.Success -> {
                    adapter.setData(cast.data.castDetails)
                }
                is Resource.Error -> {
                    binding.errorText.isVisible = true
                }
                else ->{
                    binding.errorText.isVisible = true
                }
            }
        }
    }

    private fun observeCrew(adapter: CrewAdapter){
        viewModel.credits.observe(viewLifecycleOwner){ crew ->
            when(crew){
                is Resource.Success -> {
                    adapter.setData(crew.data.crewDetails)
                }
                is Resource.Error -> {
                    binding.errorText.isVisible = true
                }
                else ->{
                    binding.errorText.isVisible = true
                }
            }
        }
    }

    private fun observeSimilarMovies(adapter: SimilarMoviesAdapter){
        viewModel.similarMovies.observe(viewLifecycleOwner){similarMovies ->
            when(similarMovies){
                is Resource.Success ->{
                    adapter.setData(similarMovies.data.results)
                }
                is Resource.Error -> {
                    binding.errorText.isVisible = true
                }
                else ->{
                    binding.errorText.isVisible = true
                }
            }
        }
    }

    private fun observeBox(adapter: BoxAdapter){
        val boxList = listOf(
            Box(R.drawable.eye_icon,"Reviews",R.drawable.box_card_view_design_red,-1),
            Box(R.drawable.camera_icon,"Movie Lists",R.drawable.box_card_view_design_blue,-1),
            Box(R.drawable.image_icon,"Posters",R.drawable.box_card_view_design_green,safeArgs.id),
        )
        adapter.setData(boxList)
    }

    private fun initYoutubePlayer(youtubeId:String){
        lifecycle.addObserver(binding.youtubePlayer)
        binding.youtubePlayer.addYouTubePlayerListener(
            object: AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.cueVideo(youtubeId,0f)
                }
            }
        )
    }

    private fun trailerNotAvailable(){
        binding.trailerMessage.isVisible = true
        binding.youtubePlayer.isVisible = false
    }

    private fun showMore(){
        binding.movieOverview.setLines(7)
        binding.showMoreTv.isVisible = false
    }

    private fun showLess(){
        val movieOverview = binding.movieOverview
        movieOverview.setLines(3)
        binding.showMoreTv.isVisible = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val TRAILER = "Trailer"
    }

}