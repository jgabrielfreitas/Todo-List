package com.kotlin.todolist.activities

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import com.jgabrielfreitas.core.Task
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.core.database.TaskManager
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.kotlin.todolist.R
import com.kotlin.todolist.adapter.TaskRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.ribot.easyadapter.ItemViewHolder
import java.math.BigInteger
import java.security.SecureRandom

@InjectLayout(layout = R.layout.activity_main)
class MainActivity : BaseActivity() {

    override fun modifyViews() {
        super.modifyViews()

        for (i in 0..3) {

            val newTask = Task()
            newTask.title   = generateText()
            newTask.content = generateText()
            TaskManager().save(newTask)
        }

        tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        tasksRecyclerView.adapter = TaskRecyclerViewAdapter(this, allTasks())
    }

    private fun allTasks(): List<Task> {
        return TaskManager().selectAll()
    }

    fun generateText(): String {

        val secureRandom = SecureRandom()
        return BigInteger(130, secureRandom).toString(32)
    }

}
