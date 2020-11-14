package com.example.dialogcalendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var listener: OnClickListener): RecyclerView.Adapter<ViewHolder>() {

    var models: MutableList<User> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    fun deleteItem(index: Int){
        models.removeAt(index)
        notifyDataSetChanged()
    }

    fun addItem(index: Int, title: String, description: String){
        models.add(User("$title", "$description"))
        notifyDataSetChanged()
    }

    fun editItem(index: Int, title: String, description: String){
        models[index].title = "$title"
        models[index].description = "$description"
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var item = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position], listener, position)
    }

    override fun getItemCount(): Int {
        return models.size
    }
}