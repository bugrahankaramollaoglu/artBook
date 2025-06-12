package com.bugrahankaramollaoglu.artbook.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bugrahankaramollaoglu.artbook.R
import com.bugrahankaramollaoglu.artbook.databinding.FragmentArtsBinding

class ArtFragment : Fragment(R.layout.fragment_arts) {

    private var fragmentBinding: FragmentArtsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentArtsBinding.bind(view)
        fragmentBinding = binding

        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }
    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

}