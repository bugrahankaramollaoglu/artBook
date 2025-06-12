package com.bugrahankaramollaoglu.artbook.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arts")
data class Art(
    var name: String, var artistName: String, var year: Int,
    var imageUrl: String,
    // bunu yaparak bunun SQL'taki id oldugunu
    // otomatik olarak id'leri numaralandırması gerektigini söylüyoruz
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) {
}