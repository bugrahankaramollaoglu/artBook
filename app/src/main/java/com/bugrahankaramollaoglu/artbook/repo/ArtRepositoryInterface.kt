package com.bugrahankaramollaoglu.artbook.repo

import androidx.lifecycle.LiveData
import com.bugrahankaramollaoglu.artbook.model.ImageResponse
import com.bugrahankaramollaoglu.artbook.room.Art
import com.bugrahankaramollaoglu.artbook.util.Resource

interface ArtRepositoryInterface {
    suspend fun insertArt(art: Art)
    suspend fun deleteArt(art: Art)
    fun getArt(): LiveData<List<Art>>
    suspend fun searchImage(imageString: String): Resource<ImageResponse>
}