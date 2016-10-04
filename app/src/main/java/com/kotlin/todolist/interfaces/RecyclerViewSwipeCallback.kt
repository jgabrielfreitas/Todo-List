package com.kotlin.todolist.interfaces

import android.support.v7.widget.RecyclerView.ViewHolder

/**
 * Created by JGabrielFreitas on 04/10/16.
 */
interface RecyclerViewSwipeCallback {

    fun onSwiped(viewHolder: ViewHolder, direction: Int)

}