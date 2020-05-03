package com.geekbrains.pictviewer.view.single

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.pictviewer.R
import com.geekbrains.pictviewer.presenter.SinglePresenter
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_simple.*

class SingleActivity : AppCompatActivity(),SingleView {
    lateinit var presenter: SinglePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val id:Int? = intent.getIntExtra("id",0)
        presenter = SinglePresenter(this,id)

    }

    override fun onImageComplete(imgUrl: String?) {
        imgUrl?.let {
            Picasso.get()
            .load(it)
            .into(largeImage)
        }
    }

}
