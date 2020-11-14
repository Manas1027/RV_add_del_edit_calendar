package com.example.dialogcalendar.calendar

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.dialogcalendar.MainActivity
import com.example.dialogcalendar.R
import kotlinx.android.synthetic.main.dialog_calendar.*
import kotlinx.android.synthetic.main.dialog_calendar.*

class CustomDialog(context: Context, activity: MainActivity): Dialog(context) {
    private val adapter = AdapterNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_calendar)
        rvCalendar.adapter = adapter
        SetData()
    }

    private fun SetData(){
        val sanlar: MutableList<Number> = mutableListOf()
        for (i in 1..100){
            sanlar.add(Number(i, false))
        }
        adapter.numbers = sanlar
    }
}