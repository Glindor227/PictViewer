package com.glindor227.pictviewer.presenter

import com.glindor227.pictviewer.App
import com.glindor227.pictviewer.model.retrofit.ImagesRepositoryImpl
import com.glindor227.pictviewer.view.image.ImageView
import javax.inject.Inject


class ImagePresenter(private val view: ImageView, id:Int?) : ImagesRepositoryImpl.ImageLargeRepositoryCallback {

    @Inject
    lateinit var imageRep:ImagesRepositoryImpl

    init {
        App.componentDagger.inject(this)
        id?.let { imageRep.getLargeImage(this,it) }
    }

    override fun callbackImageLarge(imageUrl: String?)= view.onImageComplete(imageUrl)

}
