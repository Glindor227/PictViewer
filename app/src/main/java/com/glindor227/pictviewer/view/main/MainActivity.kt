package com.glindor227.pictviewer.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.glindor227.pictviewer.R
import com.glindor227.pictviewer.model.MainNote
import com.glindor227.pictviewer.presenter.MainPresenter
import com.glindor227.pictviewer.view.image.ImageActivity
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

/**
https://github.com/Glindor227/PictViewer
Проект доделал.
Из планов на будущее:
Из программы
1) сделаю тесты
2) Прикручу Crashlytics
Для удобства
1) Сделаю "избранное" и буду хронить в ORM
2) Отправлять картинки комуто(через неявные интенты наверно).
 */
class MainActivity : MvpAppCompatActivity(),MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        presenter = MainPresenter(this)
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
                    startActivity(Intent(this@MainActivity,ImageActivity::class.java)
                        .putExtra("id",id))
                }
            }
        )
    }
}
