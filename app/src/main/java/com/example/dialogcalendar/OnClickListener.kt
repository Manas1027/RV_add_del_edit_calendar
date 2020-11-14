package com.example.dialogcalendar

import android.view.View

interface OnClickListener {
    fun OnClick(data: User)
    fun LongClick(view: View, index: Int,)
}