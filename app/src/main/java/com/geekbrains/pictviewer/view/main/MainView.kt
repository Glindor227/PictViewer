package com.geekbrains.pictviewer.view.main

import com.geekbrains.pictviewer.model.MainNote
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView: MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun onListComplete(mainNotes:List<MainNote>)
}
