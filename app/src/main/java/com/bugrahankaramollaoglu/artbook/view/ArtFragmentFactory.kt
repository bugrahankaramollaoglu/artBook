package com.bugrahankaramollaoglu.artbook.view

import android.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bugrahankaramollaoglu.artbook.adapter.ArtRecyclerAdapter
import com.bugrahankaramollaoglu.artbook.adapter.ImageRecyclerAdapter
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val artRecyclerAdapter: ArtRecyclerAdapter,
    private val glide: RequestManager,
    private val imageRecyclerAdapter: ImageRecyclerAdapter
) : FragmentFactory() {

    override fun instantiate(
        classLoader: ClassLoader,
        className: String
    ): androidx.fragment.app.Fragment {

        return when (className) {
            ArtFragment::class.java.name -> ArtFragment(artRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            ImageApiFragment::class.java.name -> ImageApiFragment(imageRecyclerAdapter)

            else -> super.instantiate(classLoader, className)
        }

    }

}