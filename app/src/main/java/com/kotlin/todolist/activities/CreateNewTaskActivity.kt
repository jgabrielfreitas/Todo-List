package com.kotlin.todolist.activities

import com.jgabrielfreitas.core.Task
import com.jgabrielfreitas.core.database.TaskManager
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.kotlin.todolist.R
import kotlinx.android.synthetic.main.activity_tasks.*

@InjectLayout(layout = R.layout.activity_tasks)
class CreateNewTaskActivity : AbstractTaskActivity() {

    override fun onDoneButtonClicked() {

        val task = Task()
        task.title   = taskTitleEditText.text.toString()
        task.content = taskContentEditText.text.toString()

        TaskManager().save(task)
        finish()
    }

}
