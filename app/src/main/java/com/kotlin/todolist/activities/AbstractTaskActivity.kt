package com.kotlin.todolist.activities

import android.view.Menu
import android.view.MenuItem
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import com.kotlin.todolist.R

/**
 * Created by JGabrielFreitas on 03/10/16.
 */

@InjectLayout(layout = R.layout.activity_tasks)
abstract class AbstractTaskActivity : BaseWithBackButtonActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_finish_task -> {
                onDoneButtonClicked()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_abstract_task, menu)
        return true
    }

    abstract fun onDoneButtonClicked()

    abstract fun validateTask() : Boolean

}