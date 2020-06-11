package com.glindor227.pictviewer.di

import androidx.room.Room
import com.glindor227.pictviewer.App
import com.glindor227.pictviewer.model.ormStorage.AppDatabase
import com.glindor227.pictviewer.model.ormStorage.repository.UrlRepositoryImpl
import com.glindor227.pictviewer.model.retrofit.ImagesRepositoryImpl
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

    @Singleton
    @Provides
    fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(mApplication.applicationContext,AppDatabase::class.java,"room_fatabase").build()
    }

}