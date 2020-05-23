package com.geekbrains.pictviewer.view.main

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.start(edit_query.text.toString())
        fab.setOnClickListener {
            progress.visibility = View.VISIBLE
            rv_notes.adapter = MainRVAdapter(ArrayList(),null)
            presenter.listRefresh(edit_query.text.toString())
        }
    }

    override fun onListComplete(mainNotes: List<MainNote>) {
        progress.visibility = View.INVISIBLE
        rv_notes.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        rv_notes.adapter = MainRVAdapter(mainNotes,
            object : Callback {
                override fun onItemClicked(id: Int) {
                    startActivity(Intent(this@MainActivity,SingleActivity::class.java)
                        .putExtra("id",id))
                }
            }
        )
    }
}
