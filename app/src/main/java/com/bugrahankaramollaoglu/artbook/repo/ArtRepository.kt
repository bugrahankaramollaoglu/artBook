package com.bugrahankaramollaoglu.artbook.repo

import androidx.lifecycle.LiveData
import com.bugrahankaramollaoglu.artbook.api.RetrofitAPI
import com.bugrahankaramollaoglu.artbook.model.ImageResponse
import com.bugrahankaramollaoglu.artbook.room.Art
import com.bugrahankaramollaoglu.artbook.room.ArtDao
import com.bugrahankaramollaoglu.artbook.util.Resource
import javax.inject.Inject

class ArtRepository @Inject constructor(
    private val artDao: ArtDao,
    private val retrofitApi: RetrofitAPI
) : ArtRepositoryInterface {
    override suspend fun insertArt(art: Art) {
        artDao.insertAt(art)
    }

    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArt()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitApi.imageSearch(imageString)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            } else {
                Resource.error("No data found!", null)
            }
        } catch (e: Exception) {
            Resource.error("Exception occurred: ${e.localizedMessage}", null)
        }
    }


}