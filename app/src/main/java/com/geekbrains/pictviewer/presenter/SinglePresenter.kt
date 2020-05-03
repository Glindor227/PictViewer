package com.geekbrains.pictviewer.presenter

import com.geekbrains.pictviewer.model.retrofit.ImagesRepositoryImpl
import com.geekbrains.pictviewer.view.single.SingleView


class SinglePresenter(private val view: SingleView, id:Int?) : ImagesRepositoryImpl.ImageLargeRepositoryCallback {
    init {
        id?.let { ImagesRepositoryImpl.getLargeImage(this,it) }
    }

    override fun callbackImageLarge(imageUrl: String?) {
        view.onImageComplete(imageUrl)
    }

}
