package com.geekbrains.pictviewer.view.main

import com.geekbrains.pictviewer.model.MainNote

interface MainView {
    fun onListComplete(mainNotes:List<MainNote>)
}
