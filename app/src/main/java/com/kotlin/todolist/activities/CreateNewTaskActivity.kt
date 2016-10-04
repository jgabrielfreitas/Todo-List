package com.kotlin.todolist.activities

import android.text.TextUtils.isEmpty
import com.jgabrielfreitas.core.Task
import com.jgabrielfreitas.core.database.TaskManager
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.kotlin.todolist.R
import com.kotlin.todolist.extentions.toast
import kotlinx.android.synthetic.main.activity_tasks.*

@InjectLayout(layout = R.layout.activity_tasks)
class CreateNewTaskActivity : AbstractTaskActivity() {

    override fun onDoneButtonClicked() {

        if (validateTask()) {
            val task = Task()
            task.title = taskTitleEditText.text.toString()
            task.content = taskContentEditText.text.toString()

            TaskManager().save(task)
            finish()
        } else
            toast(getString(R.string.msg_invalid_task))
    }

    override fun validateTask(): Boolean = !isEmpty(taskTitleEditText.text.toString()) and
                                           !isEmpty(taskContentEditText.text.toString())


}
