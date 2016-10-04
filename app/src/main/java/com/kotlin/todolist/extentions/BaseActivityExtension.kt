package com.kotlin.todolist.extentions

import android.content.Intent
import com.jgabrielfreitas.core.activity.BaseActivity

/**
 * Created by JGabrielFreitas on 04/10/16.
 */

fun BaseActivity.doIntent(clazz: Class<*>, taskId: Long) {

    val intent: Intent = Intent(this, clazz)
    intent.putExtra(getTaskTd(), taskId)
    startActivity(intent)
}

fun BaseActivity.getTaskTd(): String {
    return "_taskId"
}
