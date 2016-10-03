package com.kotlin.todolist.adapter

import android.content.Context

import com.jgabrielfreitas.core.Task
import com.kotlin.todolist.viewholders.TaskViewHolder

import uk.co.ribot.easyadapter.EasyRecyclerAdapter
import uk.co.ribot.easyadapter.ItemViewHolder

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
class TaskRecyclerViewAdapter : EasyRecyclerAdapter<Task> {

    constructor(context: Context, taskList: List<Task>) : super(context, TaskViewHolder::class.java, taskList) {
    }

    constructor(context: Context, itemViewHolderClass: Class<out ItemViewHolder<*>>, listItems: List<Task>) : super(context, itemViewHolderClass, listItems) {
    }

    constructor(context: Context, itemViewHolderClass: Class<out ItemViewHolder<*>>) : super(context, itemViewHolderClass) {
    }

    constructor(context: Context, itemViewHolderClass: Class<out ItemViewHolder<*>>, listItems: List<Task>, listener: Any) : super(context, itemViewHolderClass, listItems, listener) {
    }

    constructor(context: Context, itemViewHolderClass: Class<out ItemViewHolder<*>>, listener: Any) : super(context, itemViewHolderClass, listener) {
    }
}
