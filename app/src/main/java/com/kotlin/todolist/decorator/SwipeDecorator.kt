package com.kotlin.todolist.decorator

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback

import android.support.v7.widget.helper.ItemTouchHelper.LEFT
import android.support.v7.widget.helper.ItemTouchHelper.RIGHT
import com.kotlin.todolist.interfaces.RecyclerViewSwipeCallback

/**
 * Created by JGabrielFreitas on 04/10/16.
 */
class SwipeDecorator(callback: RecyclerViewSwipeCallback) : SimpleCallback(0, LEFT or RIGHT) {

    val swipeCallback = callback

    override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
        swipeCallback.onSwiped(viewHolder, direction)
    }

}
