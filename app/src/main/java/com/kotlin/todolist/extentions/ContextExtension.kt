package com.kotlin.todolist.extentions

import android.content.Context
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText

/**
 * Created by JGabrielFreitas on 04/10/16.
 */

fun Context.toast(message: String, duration : Int = LENGTH_SHORT) {
    makeText(this, message, duration).show()
}
