package com.geekbrains.pictviewer.model.pixabay

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PixabayClient {
    private val service: PixabayApi = Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixabayApi::class.java)
    companion object{
        private val instant = PixabayClient()
        fun getInstant(): PixabayApi {
            return instant.service;
        }

    }

}