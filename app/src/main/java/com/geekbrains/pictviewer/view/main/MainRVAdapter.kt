package com.geekbrains.pictviewer.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.pictviewer.R
import com.geekbrains.pictviewer.model.MainNote
import com.squareup.picasso.Picasso

class MainRVAdapter(private var imgs:List<MainNote>, val callback: Callback):RecyclerView.Adapter<MainRVAdapter.MainRVHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRVHolder {
        return MainRVHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.my_litle_img, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return imgs.size
    }

    override fun onBindViewHolder(holder: MainRVHolder, position: Int) {
        holder.bind(imgs[position])
    }

    inner class MainRVHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.tv_title)
        private val tvImg = itemView.findViewById<AppCompatImageView>(R.id.tv_img)
        fun bind(note: MainNote) {
            title.text = note.name
            Picasso.get()
                .load(note.urlAvatar)
                .into(tvImg)

            itemView.setOnClickListener{
                callback.onItemClicked(note)
            }
        }


    }

}