package com.glindor227.pictviewer.model.ormStorage.repository

import com.glindor227.pictviewer.App
import com.glindor227.pictviewer.model.ormStorage.AppDatabase
import com.glindor227.pictviewer.model.ormStorage.dao.ImageUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UrlRepositoryImpl :UrlRepository {

    @Inject
    lateinit var appDatabase: AppDatabase

    init {
        App.componentDagger.inject(this)
    }

    var urlDao = appDatabase.getDAO()

    override fun getUrls(urlCallback:UrlListRepositoryCallback) {
        GlobalScope.launch{
            val transList = urlDao.getAllUrl()
            withContext(Dispatchers.Main) {
                urlCallback.callbackUrlList(transList)
            }
        }
    }

    override fun addUrl(id:Int,name:String?,url: String?) {
        GlobalScope.launch{
            url?.let { name?.let { it1 -> ImageUrl(id, it1, it) } }?.let { urlDao.addUrl(it) }
        }

    }

    override fun clear() {
        GlobalScope.launch{
            urlDao.clear()
        }
    }

    interface UrlListRepositoryCallback{
        fun callbackUrlList(images: List<ImageUrl>)
    }

}