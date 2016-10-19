package com.kotlin.todolist.activities

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.ViewHolder
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import com.jgabrielfreitas.core.Task
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.core.database.TaskManager
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.kotlin.todolist.R
import com.kotlin.todolist.R.string.msg_task_removed
import com.kotlin.todolist.adapter.TaskRecyclerViewAdapter
import com.kotlin.todolist.decorator.SwipeDecorator
import com.kotlin.todolist.extentions.doIntent
import com.kotlin.todolist.extentions.toast
import com.kotlin.todolist.interfaces.OnItemClickListener
import com.kotlin.todolist.interfaces.RecyclerViewSwipeCallback
import kotlinx.android.synthetic.main.activity_main.*

@InjectLayout(layout = R.layout.activity_main)
class MainActivity : BaseActivity(), OnItemClickListener<Task>, RecyclerViewSwipeCallback {

    val taskManager = TaskManager()

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        // when is a control flow as 'switch case'
        when(item?.itemId) {
            R.id.action_new_task -> doIntent(CreateNewTaskActivity::class.java)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun modifyViews() {
        super.modifyViews()

        killAfterIntent = false
        tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        tasksRecyclerView.adapter = TaskRecyclerViewAdapter(this, allTasks(), this)

        val itemTouchHelper = ItemTouchHelper(SwipeDecorator(this))
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView)

        updateUiTask()
    }

    override fun onResume() {
        super.onResume()

        if (tasksRecyclerView.adapter is TaskRecyclerViewAdapter) {
            (tasksRecyclerView.adapter as TaskRecyclerViewAdapter).items = allTasks()
            tasksRecyclerView.adapter.notifyDataSetChanged()
        }
    }

    private fun allTasks(): List<Task> = taskManager.selectAll()

    override fun onItemClick(item: Task) = doIntent(EditTaskActivity::class.java, item.id)

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {

        val taskToDelete = allTasks()[viewHolder.adapterPosition]

        (tasksRecyclerView.adapter as TaskRecyclerViewAdapter).removeItem(taskToDelete)
        taskManager.delete(taskToDelete)
        toast(getString(msg_task_removed))
        updateUiTask()
    }

    private fun updateUiTask() {
        when(allTasks().size) {
            0    -> noTaskToShowtextView.visibility = VISIBLE
            else -> noTaskToShowtextView.visibility = GONE
        }
    }

}
