package com.bugrahankaramollaoglu.artbook.model

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class ImageResult(
    val comments: Int,
    val downloads: Int,
    val favourites: Int,
    val id: Int,
    val imageHeight: Int,
    val imageWidth: Int,
    val imageSize: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val tags: String,
    val type: String,
    val user: String,
    @SerializedName("user_id")
    val userId: Int,
    val userImageURL: String,
    val views: Int,
    val webformatHeight: Int,
    val webformatWidth: Int,
    val webformatURL: String,
)
