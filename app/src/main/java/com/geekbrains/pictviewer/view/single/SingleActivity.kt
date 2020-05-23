package com.geekbrains.pictviewer.view.single

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.pictviewer.R
import com.geekbrains.pictviewer.presenter.SinglePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_simple.*

class SingleActivity : AppCompatActivity(),SingleView {
    lateinit var presenter: SinglePresenter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        setSupportActionBar(toolbar)

        val id:Int? = intent.getIntExtra("id",0)
        presenter = SinglePresenter(this,id)

    }

    override fun onImageComplete(imgUrl: String?) {
        imgUrl?.let {
            Picasso.get()
                .load(it)
                .into(largeImage)
        }
        progressSimple.visibility = View.INVISIBLE

    }


}
