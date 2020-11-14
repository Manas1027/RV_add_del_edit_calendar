package com.example.dialogcalendar.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dialogcalendar.R

class AdapterNumber: RecyclerView.Adapter<ViewHolderNumber>() {

    var previousIndex: Int = -1
    var nextIndex: Int = -1
    set(value) {
        previousIndex = nextIndex
        field = value
        if (previousIndex != -1){
            numbers[previousIndex].isSelected = false
            notifyItemChanged(previousIndex)
        }
    }


    var numbers: MutableList<Number> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNumber {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        return ViewHolderNumber(view)
    }

    override fun onBindViewHolder(holder: ViewHolderNumber, position: Int) {
        holder.populateModel(numbers[position], position, this)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }
}