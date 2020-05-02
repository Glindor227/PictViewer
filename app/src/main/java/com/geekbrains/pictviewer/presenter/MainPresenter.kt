package com.geekbrains.pictviewer.presenter

import com.geekbrains.pictviewer.model.MainNote
import com.geekbrains.pictviewer.model.pixabay.PixabayHit
import com.geekbrains.pictviewer.model.retrofit.ImagesRepositoryImpl
import com.geekbrains.pictviewer.view.main.MainView

class MainPresenter(private val mainView: MainView): ImagesRepositoryImpl.ImagesRepositoryCallback {
    private var nodes:MutableList<MainNote> = ArrayList()
    private var repository:ImagesRepositoryImpl= ImagesRepositoryImpl(this)
    init {
        repository.getImages()
    }

    override fun callback(images: List<PixabayHit>) {
        images.forEach{
            nodes.add(MainNote(it.id!!,it.user!!,it.webFormatURL!!))
        }
        mainView.onListComplete(nodes)
    }

}
