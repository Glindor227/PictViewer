package com.geekbrains.pictviewer.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.geekbrains.pictviewer.R
import com.geekbrains.pictviewer.model.MainNote
import com.geekbrains.pictviewer.presenter.MainPresenter
import com.geekbrains.pictviewer.view.single.SingleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    //TODO обавить moxy
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
    }

    override fun onListComplete(mainNotes: List<MainNote>) {
        rv_notes.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        rv_notes.adapter = MainRVAdapter(mainNotes,
            object : Callback {
                override fun onItemClicked(id: Int) {
                    startActivity(Intent(this@MainActivity,SingleActivity::class.java).putExtra("id",id))
                }
            }
        )
    }
}
