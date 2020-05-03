package com.geekbrains.pictviewer.model.retrofit

interface ImagesRepository {
    fun getImages(repositoryCallback: ImagesRepositoryImpl.ImagesListRepositoryCallback)
    fun getLargeImage(repositoryCallback: ImagesRepositoryImpl.ImageLargeRepositoryCallback, id :Int)
}