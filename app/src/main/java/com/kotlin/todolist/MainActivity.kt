package com.kotlin.todolist

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import com.jgabrielfreitas.core.Task
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.core.database.TaskDao
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*

@InjectLayout(layout = R.layout.activity_main)
class MainActivity : BaseActivity() {

    override fun modifyViews() {

        tapButton.setOnClickListener {

            val taskDao = TaskDao(this)
            taskDao.init()

            val realResult = taskDao.selectAll()
            makeText(this, "Base size: ${realResult!!.size}", LENGTH_SHORT).show()
        }
    }
}
