package com.glindor227.pictviewer.model.retrofit.pixabay

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class PixabayResponse {
    @SerializedName("totalHits")
    @Expose
    private val totalHits:Int? = null
    @SerializedName("hits")
    @Expose
    private val hits: List<PixabayHit>? = null
    @SerializedName("total")
    @Expose
    private val total = 0

    fun getHits():List<PixabayHit>?{
        return hits
    }
}