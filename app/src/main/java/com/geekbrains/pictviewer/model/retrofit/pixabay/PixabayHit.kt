package com.geekbrains.pictviewer.model.retrofit.pixabay

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PixabayHit {
    @SerializedName("id")
    @Expose
    val id:Int? = null

    @SerializedName("webformatURL")
    @Expose
    val webFormatURL:String? = null

    @SerializedName("tags")
    @Expose
    val tags:String? = null

    @SerializedName("largeImageURL")
    @Expose
    val largeImageURL:String? = null

    @SerializedName("user")
    @Expose
    val user:String? = null

}
