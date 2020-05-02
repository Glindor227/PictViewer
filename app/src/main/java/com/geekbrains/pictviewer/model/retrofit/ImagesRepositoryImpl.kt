package com.geekbrains.pictviewer.model.retrofit

import com.geekbrains.pictviewer.model.pixabay.PixabayClient
import com.geekbrains.pictviewer.model.pixabay.PixabayHit
import com.geekbrains.pictviewer.model.pixabay.PixabayResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesRepositoryImpl(val repositoryCallback:ImagesRepositoryCallback):ImagesRepository {

    private val map:HashMap<String,String> = HashMap()
    override fun getImages() {
        map["key"] = "16280154-5a3440fd58a823be15e831ac3";
        map["lang"] = "ru";
        map["image_type"] = "all";
        map["page"] = "1";
        PixabayClient.getInstant().getImages(map).enqueue(object : Callback<PixabayResponse> {

            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                response.body()?.getHits()?.let { repositoryCallback.callback(it) };

            }

            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
    interface ImagesRepositoryCallback{
        fun callback(images: List<PixabayHit>)
    }

}