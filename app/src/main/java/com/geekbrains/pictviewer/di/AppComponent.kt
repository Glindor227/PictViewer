package com.geekbrains.pictviewer.di

import com.geekbrains.pictviewer.presenter.MainPresenter
import com.geekbrains.pictviewer.presenter.SinglePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainP:MainPresenter)
    fun inject(simpleP:SinglePresenter)
}