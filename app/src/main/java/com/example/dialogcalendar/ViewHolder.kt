package com.example.dialogcalendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun populateModel(data: User, listener: OnClickListener, index: Int){
        itemView.name.text = data.title
        itemView.surname.text = data.description

        itemView.setOnClickListener {
            listener.OnClick(data)
        }
        itemView.setOnLongClickListener {
            listener.LongClick(itemView, index)
            return@setOnLongClickListener true
        }
    }


}