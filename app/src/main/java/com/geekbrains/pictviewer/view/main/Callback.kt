package com.geekbrains.pictviewer.view.main

import com.geekbrains.pictviewer.model.MainNote

interface Callback {
    fun onItemClicked(item: MainNote)
}
