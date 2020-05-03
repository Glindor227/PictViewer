package com.geekbrains.pictviewer.model.pixabay

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PixabayApi {
    @GET("api")
    fun getImages(@QueryMap parameter:Map<String, String>): Call<PixabayResponse>
}