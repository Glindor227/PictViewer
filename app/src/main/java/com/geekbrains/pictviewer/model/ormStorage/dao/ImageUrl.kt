package com.geekbrains.pictviewer.model.ormStorage.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_url")
class ImageUrl(@PrimaryKey var id:Int = 0,var name:String, var url:String) {
}