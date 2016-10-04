package com.kotlin.todolist.activities

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import com.jgabrielfreitas.core.Task
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.core.database.TaskManager
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.kotlin.todolist.R
import com.kotlin.todolist.adapter.TaskRecyclerViewAdapter
import com.kotlin.todolist.decorator.SimpleDividerItemDecoration
import com.kotlin.todolist.decorator.SwipeDecorator
import com.kotlin.todolist.extentions.doIntent
import com.kotlin.todolist.interfaces.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

@InjectLayout(layout = R.layout.activity_main)
class MainActivity : BaseActivity(), OnItemClickListener<Task> {

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
        tasksRecyclerView.addItemDecoration(SimpleDividerItemDecoration(this))

        val itemTouchHelper = ItemTouchHelper(SwipeDecorator())
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView)
    }

    override fun onResume() {
        super.onResume()

        if (tasksRecyclerView.adapter is TaskRecyclerViewAdapter) {
            (tasksRecyclerView.adapter as TaskRecyclerViewAdapter).items = allTasks()
            tasksRecyclerView.adapter.notifyDataSetChanged()
        }
    }

    private fun allTasks(): List<Task> = TaskManager().selectAll()

    override fun onItemClick(item: Task) = doIntent(EditTaskActivity::class.java, item.id)

}
