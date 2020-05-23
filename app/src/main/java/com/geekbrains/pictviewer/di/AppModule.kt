package com.geekbrains.pictviewer.di

import com.geekbrains.pictviewer.App
import com.geekbrains.pictviewer.model.ormStorage.repository.UrlRepositoryImpl
import com.geekbrains.pictviewer.model.retrofit.ImagesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(internal var mApplication: App) {
    @Singleton
    @Provides
    fun getImageRep(): ImagesRepositoryImpl{
        return ImagesRepositoryImpl()
    }

    @Singleton
    @Provides
    fun getUrlRep(): UrlRepositoryImpl{
        return UrlRepositoryImpl()
    }

}