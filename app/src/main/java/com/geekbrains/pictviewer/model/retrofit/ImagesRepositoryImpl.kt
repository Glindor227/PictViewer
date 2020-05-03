package com.geekbrains.pictviewer.model.retrofit

import com.geekbrains.pictviewer.model.pixabay.PixabayClient
import com.geekbrains.pictviewer.model.pixabay.PixabayHit
import com.geekbrains.pictviewer.model.pixabay.PixabayResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ImagesRepositoryImpl: ImagesRepository {

    private val mapKey:HashMap<String,String> = HashMap()
    override fun getImages(repositoryCallback:ImagesListRepositoryCallback) {
        mapKey.clear()
        mapKey["key"] = "16280154-5a3440fd58a823be15e831ac3"
        mapKey["lang"] = "ru"
        mapKey["image_type"] = "all"
        mapKey["page"] = "1"
        repositoryBaseFunction {
            repositoryCallback.callbackImagesList(it.body()?.getHits()!!)
        }
    }

    override fun getLargeImage(repositoryCallback:ImageLargeRepositoryCallback, id: Int) {
        mapKey.clear()
        mapKey["key"] = "16280154-5a3440fd58a823be15e831ac3"
        mapKey["id"] =  id.toString()
        repositoryBaseFunction {
            repositoryCallback.callbackImageLarge(it.body()?.getHits()?.get(0)?.largeImageURL)
        }
    }

    private fun repositoryBaseFunction(foo:(r:Response<PixabayResponse>)->Unit){
        PixabayClient.getInstant().getImages(mapKey).enqueue(object : Callback<PixabayResponse> {
            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) =
                foo(response)
            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) =
                t.printStackTrace()
        })
    }

    interface ImagesListRepositoryCallback{
        fun callbackImagesList(images: List<PixabayHit>)
    }
    interface ImageLargeRepositoryCallback{
        fun callbackImageLarge(imageUrl: String?)
    }

}