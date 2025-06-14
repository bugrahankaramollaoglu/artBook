package com.bugrahankaramollaoglu.artbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bugrahankaramollaoglu.artbook.R
import com.bugrahankaramollaoglu.artbook.adapter.ImageRecyclerAdapter.ImageViewHolder
import com.bugrahankaramollaoglu.artbook.room.Art
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ImageRecyclerAdapter @Inject constructor(
    val glide: RequestManager
) : RecyclerView.Adapter<ImageViewHolder>() {


    private var onItemClickListener: ((String) -> Unit)? = null

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // diff utility

    private val diffUtil = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var images: List<String>
        get() = recyclerListDiffer.currentList
        set(value) = recyclerListDiffer.submitList(value)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_row, parent, false)
        return ImageViewHolder(view)
    }

    fun setOnItemClickListenerr(listener: (String) -> Unit) {
        onItemClickListener = listener
    }


    override fun onBindViewHolder(
        holder: ImageViewHolder,
        position: Int
    ) {
        val imageView = holder.itemView.findViewById<ImageView>(R.id.singleArtImageView)
        val url = images[position]
        holder.itemView.apply {
            glide.load(url).into(imageView)

            // üstüne tıklanılan resmin url'sini böylelikle alabiliyoruz
            setOnItemClickListenerr {
                onItemClickListener?.let {
                    it(url)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

}