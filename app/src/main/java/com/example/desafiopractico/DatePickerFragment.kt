package com.example.desafiopractico

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.lang.reflect.Field
import java.util.Calendar

class DatePickerFragment(val listener: (day:Int,month:Int,year:Int)-> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth,month,year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context,this, year, month,day)
        return picker
    }
}

