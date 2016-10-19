package com.kotlin.todolist.activities

import android.view.MenuItem

import com.jgabrielfreitas.core.activity.BaseActivity

/**
 * Created by JGabrielFreitas on 03/10/16.
 */

open class BaseWithBackButtonActivity : BaseActivity() {

    override fun modifyViews() {
        super.modifyViews()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onUpButtonClicked()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    protected fun onUpButtonClicked() {
        killThisActivity()
    }

}
