package com.glindor227.pictviewer.model.retrofit.pixabay

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PixabayApi {
    @GET("api")
    fun getImagesApi(@QueryMap parameter:Map<String, String>): Call<PixabayResponse>
}