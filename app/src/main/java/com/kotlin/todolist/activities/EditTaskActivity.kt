package com.kotlin.todolist.activities

import android.text.TextUtils
import com.jgabrielfreitas.core.Task
import com.jgabrielfreitas.core.database.TaskManager
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.kotlin.todolist.R
import com.kotlin.todolist.extentions.getTaskTd
import com.kotlin.todolist.extentions.toast
import kotlinx.android.synthetic.main.activity_tasks.*

@InjectLayout(layout = R.layout.activity_tasks)
class EditTaskActivity : AbstractTaskActivity() {

    val taskManager = TaskManager()
    var taskFromBase: Task? = null

    override fun modifyViews() {
        super.modifyViews()

        // get task id for select
        val intentFromAnotherActivity = intent

        // current task id
        val selectedTaskId = intentFromAnotherActivity.getLongExtra(getTaskTd(), 0)

        // get task from base
        taskFromBase = taskManager.findWithId(selectedTaskId)

        // set task information to views
        taskTitleEditText.setText(taskFromBase!!.title)
        taskContentEditText.setText(taskFromBase!!.content)
    }

    override fun onDoneButtonClicked() {

        if (validateTask()) {

            // update information
            taskFromBase!!.title   = taskTitleEditText.text.toString()
            taskFromBase!!.content = taskContentEditText.text.toString()

            // update task
            taskManager.update(taskFromBase!!)
            finish()
        } else
            toast(getString(R.string.msg_invalid_task))

    }

    // check if title or content are different null
    override fun validateTask(): Boolean = !TextUtils.isEmpty(taskTitleEditText.text.toString()) and
                                           !TextUtils.isEmpty(taskContentEditText.text.toString())

}
