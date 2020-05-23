package com.geekbrains.pictviewer.model.ormStorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geekbrains.pictviewer.model.ormStorage.dao.ImageUrl
import com.geekbrains.pictviewer.model.ormStorage.dao.ImageUrlDAO

@Database(entities = arrayOf(ImageUrl::class),version = 1,exportSchema = false)
abstract class  AppDatabase:RoomDatabase() {
    abstract fun getDAO(): ImageUrlDAO
}