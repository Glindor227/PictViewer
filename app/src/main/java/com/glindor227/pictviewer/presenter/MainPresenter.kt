package com.glindor227.pictviewer.presenter

import com.glindor227.pictviewer.App
import com.glindor227.pictviewer.model.MainNote
import com.glindor227.pictviewer.model.ormStorage.dao.ImageUrl
import com.glindor227.pictviewer.model.ormStorage.repository.UrlRepositoryImpl
import com.glindor227.pictviewer.model.retrofit.ImagesRepositoryImpl
import com.glindor227.pictviewer.model.retrofit.pixabay.PixabayHit
import com.glindor227.pictviewer.view.main.MainView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter: MvpPresenter<MainView>(),ImagesRepositoryImpl.ImagesListRepositoryCallback,
    UrlRepositoryImpl.UrlListRepositoryCallback{
    private var nodes:MutableList<MainNote> = mutableListOf()
    private lateinit var query:String
    @Inject
    lateinit var urlRep:UrlRepositoryImpl

    @Inject
    lateinit var imageRep:ImagesRepositoryImpl

    init {
        App.componentDagger.inject(this)
    }
    fun start(queryInit: String) {
        query = queryInit
        urlRep.getUrls(this)
    }

    fun listRefresh(edit_query:String){
        query = edit_query
        urlRep.clear()
        imageRep.getImages(edit_query,this)
    }

    override fun callbackImagesList(images: List<PixabayHit>) {
        nodes.clear()
        images.forEach{
            nodes.add(MainNote(it.id,it.user,it.webFormatURL))
            urlRep.addUrl(it.id,it.user,it.webFormatURL)
        }
        viewState.onListComplete(nodes)
    }

    override fun callbackUrlList(images: List<ImageUrl>) {
        if(images.isEmpty()) {
            imageRep.getImages(query,this)
            return
        }
        images.forEach{
            nodes.add(MainNote(it.id,it.name,it.url))
        }
        viewState.onListComplete(nodes)
    }

}
