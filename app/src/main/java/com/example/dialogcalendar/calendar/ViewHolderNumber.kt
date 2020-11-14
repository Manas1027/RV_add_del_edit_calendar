package com.example.dialogcalendar.calendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_number.view.*

class ViewHolderNumber(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun populateModel(data: Number, index: Int, adapter: AdapterNumber){
        itemView.tvNumber.text = data.number.toString()
        if(!data.isSelected){
            itemView.ivBg.visibility = View.INVISIBLE
        } else {
            itemView.ivBg.visibility = View.VISIBLE
        }

        itemView.setOnClickListener {
            itemView.ivBg.visibility = View.VISIBLE
            adapter.nextIndex = index
        }
    }


}