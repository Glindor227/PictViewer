package com.geekbrains.pictviewer.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.geekbrains.pictviewer.R
import com.geekbrains.pictviewer.model.MainNote
import com.geekbrains.pictviewer.presenter.MainPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    //TODO обавить moxy
    private lateinit var mainPresentor: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresentor = MainPresenter(this);
    }

    override fun onListComplete(mainNotes: List<MainNote>) {
        rv_notes.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        rv_notes.adapter = MainRVAdapter(mainNotes,
            object : Callback {
                override fun onItemClicked(item: MainNote) {
                    findViewById<android.view.View?>(android.R.id.content)?.let {
                        Snackbar.make(it, "press"+item.num, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show()
                    }
                }
            }
        )
    }
}
