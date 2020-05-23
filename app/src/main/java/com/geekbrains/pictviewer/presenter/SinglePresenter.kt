package com.geekbrains.pictviewer.presenter

import android.os.Build
import androidx.annotation.RequiresApi
import com.geekbrains.pictviewer.App
import com.geekbrains.pictviewer.model.retrofit.ImagesRepositoryImpl
import com.geekbrains.pictviewer.view.single.SingleView
import javax.inject.Inject


@RequiresApi(Build.VERSION_CODES.O)
class SinglePresenter(private val view: SingleView, id:Int?) : ImagesRepositoryImpl.ImageLargeRepositoryCallback {

    @Inject
    lateinit var imageRep:ImagesRepositoryImpl

    init {
        App.componentDagger.inject(this)
        id?.let { imageRep.getLargeImage(this,it) }
    }

    override fun callbackImageLarge(imageUrl: String?)= view.onImageComplete(imageUrl)

}
