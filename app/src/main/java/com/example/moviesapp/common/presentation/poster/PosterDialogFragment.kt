package com.example.moviesapp.common.presentation.poster

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.common.data.api.ApiConstants
import com.example.moviesapp.common.utils.AndroidDownloader
import com.example.moviesapp.common.utils.setImage
import com.example.moviesapp.databinding.FragmentPosterDialogBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PosterDialogFragment :DialogFragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentPosterDialogBinding?= null

    private val safeArgs:PosterDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPosterDialogBinding.inflate(layoutInflater,container,false)
        setImage()
        initListeners()
        makeBackgroundTransparent()
        return binding.root
    }

    private fun initListeners(){
        binding.downloadButton.setOnClickListener {
            downloadImage()
            dialog?.dismiss()
            Toast.makeText(requireContext(), "Download completed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setImage(){
        binding.dialogPoster.setImage(ApiConstants.IMG_URL + safeArgs.path)
    }

    private fun downloadImage(){
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            val downloader = AndroidDownloader(requireContext())
            downloader.downloadFile(ApiConstants.IMG_URL + safeArgs.path)
        }
    }

    private fun makeBackgroundTransparent(){
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
