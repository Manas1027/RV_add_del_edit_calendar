package com.example.dialogcalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogcalendar.calendar.CustomDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_calendar.view.*
import kotlinx.android.synthetic.main.dialog_calendar.view.btnNegative
import kotlinx.android.synthetic.main.dialog_calendar.view.btnPositive
import kotlinx.android.synthetic.main.dialog_custom_add.view.*

class MainActivity : AppCompatActivity(), OnClickListener {

    var myAdapter = Adapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RV.adapter = myAdapter
        setData()
    }

    fun setData(){
        var params: MutableList<User> = mutableListOf()
        for (i in 1..5){
            params.add(User("Title $i", "Descripton $i"))
        }
        myAdapter.models = params
    }

    override fun OnClick(data: User) {
        Toast.makeText(this, "${data.title} is clicked", Toast.LENGTH_SHORT).show()
    }

    override fun LongClick(view: View, index: Int) {
        var popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.context_menu)

        popupMenu.setOnMenuItemClickListener {
            when(it.itemId){

                R.id.add -> {
                    val addDialog = LayoutInflater.from(this).inflate(R.layout.dialog_custom_add, null)
                    val dialog = AlertDialog.Builder(this).setView(addDialog).show()

                    addDialog.btnPositive.setOnClickListener {
                        myAdapter.addItem(index, addDialog.userTitle.text.toString(), addDialog.userDescription.text.toString())
                        dialog.dismiss()
                    }
                    addDialog.btnNegative.setOnClickListener {
                        dialog.dismiss()
                    }
                }

                R.id.edit -> {
                    val editDialog = LayoutInflater.from(this).inflate(R.layout.dialog_custom_add, null)
                    val dialog = AlertDialog.Builder(this).setView(editDialog).show()
                    //editDialog.userTitle.text = myAdapter.models[index].title.toString()
                    //editDialog.userDescription.text = myAdapter.models[index].description.toString()

                    editDialog.btnPositive.setOnClickListener {
                        myAdapter.editItem(index, editDialog.userTitle.text.toString(), editDialog.userDescription.text.toString())
                        dialog.dismiss()
                    }
                    editDialog.btnNegative.setOnClickListener {
                        dialog.dismiss()
                    }
                }
                R.id.delete -> {
                    myAdapter.deleteItem(index)
                }
                R.id.calendar -> {
                    val dialog = CustomDialog(this, this)
                    dialog.show()
                }
            }
            return@setOnMenuItemClickListener true
        }

        popupMenu.show()
        }
    }


