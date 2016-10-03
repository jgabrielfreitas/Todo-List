package com.kotlin.todolist.activities

import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
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

        killAfterIntent = false
        tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        tasksRecyclerView.adapter = TaskRecyclerViewAdapter(this, allTasks())
    }

    override fun onResume() {
        super.onResume()

        if (tasksRecyclerView.adapter is TaskRecyclerViewAdapter) {
            (tasksRecyclerView.adapter as TaskRecyclerViewAdapter).items = allTasks()
            tasksRecyclerView.adapter.notifyDataSetChanged()
        }
    }

    private fun allTasks(): List<Task> {
        return TaskManager().selectAll()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        // when is a control flow as 'switch case'
        when(item?.itemId) {
            R.id.action_new_task -> doIntent(CreateNewTaskActivity::class.java)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return true
    }

}
