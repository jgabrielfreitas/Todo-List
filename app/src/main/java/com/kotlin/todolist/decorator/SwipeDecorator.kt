package com.kotlin.todolist.decorator

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback

import android.support.v7.widget.helper.ItemTouchHelper.LEFT
import android.support.v7.widget.helper.ItemTouchHelper.RIGHT

/**
 * Created by JGabrielFreitas on 04/10/16.
 */
class SwipeDecorator : SimpleCallback(0, LEFT or RIGHT) {

    override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {

    }

}
