package com.kotlin.todolist

import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.layoutid.annotations.InjectLayout
import kotlinx.android.synthetic.main.activity_main.*

@InjectLayout(layout = R.layout.activity_main)
class MainActivity : BaseActivity() {

    override fun modifyViews() {
        helloTextView.text = "Hello Kotlin!"
    }
}
