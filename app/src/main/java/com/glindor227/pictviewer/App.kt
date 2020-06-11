package com.glindor227.pictviewer

import android.app.Application
import com.glindor227.pictviewer.di.AppComponent
import com.glindor227.pictviewer.di.AppModule
import com.glindor227.pictviewer.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        componentDagger=DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object{
        @JvmStatic lateinit var componentDagger: AppComponent
    }
}