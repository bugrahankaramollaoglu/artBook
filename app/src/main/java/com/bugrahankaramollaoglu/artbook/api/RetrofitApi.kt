package com.bugrahankaramollaoglu.artbook.api

import com.bugrahankaramollaoglu.artbook.model.ImageResponse
import com.bugrahankaramollaoglu.artbook.util.Util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("/api/")
    suspend fun imageSearch(
        @Query("q") searchQuery: String,
        @Query("q") apiKey: String = API_KEY
    ): Response<ImageResponse>
}