package com.glindor227.pictviewer.model.ormStorage.repository

interface UrlRepository {
    fun getUrls(urlCallback: UrlRepositoryImpl.UrlListRepositoryCallback)
    fun clear()
    fun addUrl(id: Int, name: String?, url: String?)
}