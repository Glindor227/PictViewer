package com.geekbrains.pictviewer.model.retrofit

interface ImagesRepository {
    fun getImages(query:String,repositoryCallback: ImagesRepositoryImpl.ImagesListRepositoryCallback)
    fun getLargeImage(repositoryCallback: ImagesRepositoryImpl.ImageLargeRepositoryCallback, id :Int)
}