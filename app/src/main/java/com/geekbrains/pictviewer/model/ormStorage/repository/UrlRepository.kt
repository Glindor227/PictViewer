package com.geekbrains.pictviewer.model.ormStorage.repository

interface UrlRepository {
    fun getUrls(urlCallback: UrlRepositoryImpl.UrlListRepositoryCallback)
    fun addUrl(id:Int,name:String,url:String)
    fun clear()
}