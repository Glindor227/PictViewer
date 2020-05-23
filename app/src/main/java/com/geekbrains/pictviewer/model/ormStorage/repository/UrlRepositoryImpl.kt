package com.geekbrains.pictviewer.model.ormStorage.repository

import com.geekbrains.pictviewer.App
import com.geekbrains.pictviewer.model.ormStorage.dao.ImageUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UrlRepositoryImpl :UrlRepository {
    var urlDao = App.appDatabase.getDAO()

    override fun getUrls(urlCallback:UrlListRepositoryCallback) {
        GlobalScope.launch{
            val transList = urlDao.getAllUrl()
            withContext(Dispatchers.Main) {
                urlCallback.callbackUrlList(transList)
            }
        }
    }

    override fun addUrl(id:Int,name:String,url: String) {
        GlobalScope.launch{
            urlDao.addUrl(ImageUrl(id,name,url))
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