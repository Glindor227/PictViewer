package com.geekbrains.pictviewer.model.retrofit

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.geekbrains.pictviewer.model.retrofit.pixabay.PixabayClient
import com.geekbrains.pictviewer.model.retrofit.pixabay.PixabayHit
import com.geekbrains.pictviewer.model.retrofit.pixabay.PixabayResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalTime

class ImagesRepositoryImpl: ImagesRepository {

    private val mapKey:HashMap<String,String> = HashMap()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getImages(query:String,repositoryCallback:ImagesListRepositoryCallback) {
        mapKey.clear()
        mapKey["key"] = "16280154-5a3440fd58a823be15e831ac3"
        mapKey["lang"] = "ru"
        mapKey["q"] = query
        mapKey["per_page"] = "20"
        mapKey["page"] = "1"

        Log.d("TimeTest","call getImages("+query+")" + LocalTime.now().toString());
        repositoryBaseFunction {
            Log.d("TimeTest","rezult getImages(count="+it.body()?.getHits()?.size+") " + LocalTime.now().toString());
            repositoryCallback.callbackImagesList(it.body()?.getHits()!!)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getLargeImage(repositoryCallback:ImageLargeRepositoryCallback, id: Int) {
        mapKey.clear()
        mapKey["key"] = "16280154-5a3440fd58a823be15e831ac3"
        mapKey["id"] =  id.toString()
        Log.d("TimeTest","call getLargeImage($id)" + LocalTime.now().toString());
        repositoryBaseFunction {
            Log.d("TimeTest","rezult getLargeImage(count="+it.body()?.getHits()?.size+")  " + LocalTime.now().toString());
            repositoryCallback.callbackImageLarge(it.body()?.getHits()?.get(0)?.largeImageURL)
        }
    }

    private fun repositoryBaseFunction(foo:(r:Response<PixabayResponse>)->Unit){
        PixabayClient.getInstant().getImagesApi(mapKey).enqueue(object : Callback<PixabayResponse> {
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