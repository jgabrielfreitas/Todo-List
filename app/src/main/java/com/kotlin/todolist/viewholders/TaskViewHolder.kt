package com.kotlin.todolist.viewholders

import android.view.View
import android.widget.TextView

import com.jgabrielfreitas.core.Task
import com.kotlin.todolist.R

import uk.co.ribot.easyadapter.ItemViewHolder
import uk.co.ribot.easyadapter.PositionInfo
import uk.co.ribot.easyadapter.annotations.LayoutId
import uk.co.ribot.easyadapter.annotations.ViewId

/**
 * Created by JGabrielFreitas on 03/10/16.
 */

@LayoutId(R.layout.row_task_view_holder)
class TaskViewHolder(view: View) : ItemViewHolder<Task>(view) {

    @ViewId(R.id.taskTitleTextView)   val taskTitleTextView   : TextView? = null
    @ViewId(R.id.taskContentTextView) val taskContentTextView : TextView? = null

    override fun onSetValues(item: Task, positionInfo: PositionInfo) {

        taskTitleTextView!!.text   = item.title
        taskContentTextView!!.text = item.content
    }
}
