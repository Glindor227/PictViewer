package com.glindor227.pictviewer.model.ormStorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.glindor227.pictviewer.model.ormStorage.dao.ImageUrl
import com.glindor227.pictviewer.model.ormStorage.dao.ImageUrlDAO

@Database(entities = [ImageUrl::class],version = 1,exportSchema = false)
abstract class  AppDatabase:RoomDatabase() {
    abstract fun getDAO(): ImageUrlDAO
}