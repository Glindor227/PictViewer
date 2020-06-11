package com.glindor227.pictviewer.di

import com.glindor227.pictviewer.model.ormStorage.repository.UrlRepositoryImpl
import com.glindor227.pictviewer.presenter.ImagePresenter
import com.glindor227.pictviewer.presenter.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainP:MainPresenter)
    fun inject(simpleP:ImagePresenter)
    fun inject(urlRep: UrlRepositoryImpl)

}