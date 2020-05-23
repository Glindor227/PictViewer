package com.geekbrains.pictviewer

import android.app.Application
import androidx.room.Room
import com.geekbrains.pictviewer.di.AppComponent
import com.geekbrains.pictviewer.di.AppModule
import com.geekbrains.pictviewer.di.DaggerAppComponent
import com.geekbrains.pictviewer.model.ormStorage.AppDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appDatabase =Room.databaseBuilder(applicationContext,AppDatabase::class.java,"room_fatabase").build()
        componentDagger=DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object{
        lateinit var appDatabase:AppDatabase
        @JvmStatic lateinit var componentDagger: AppComponent
    }
}