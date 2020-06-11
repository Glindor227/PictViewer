package com.glindor227.pictviewer.view.image

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.glindor227.pictviewer.R
import com.glindor227.pictviewer.presenter.ImagePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_simple.*

class ImageActivity : AppCompatActivity(),ImageView {
    lateinit var presenter: ImagePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        setSupportActionBar(toolbar)

        val id:Int? = intent.getIntExtra("id",0)
        presenter = ImagePresenter(this,id)

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
