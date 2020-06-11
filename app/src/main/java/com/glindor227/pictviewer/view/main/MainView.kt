package com.glindor227.pictviewer.view.main

import com.glindor227.pictviewer.model.MainNote
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView: MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun onListComplete(mainNotes:List<MainNote>)
}
