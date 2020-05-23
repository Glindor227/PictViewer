package com.geekbrains.pictviewer.model.ormStorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ImageUrlDAO {

    @Query("SELECT * FROM table_url")
    fun getAllUrl(): List<ImageUrl>

    @Query("SELECT COUNT(*) FROM table_url")
    fun getCountUrl(): Int

    @Insert
    fun addUrl(users: ImageUrl): Long

    @Query("DELETE FROM table_url")
    fun clear()

}