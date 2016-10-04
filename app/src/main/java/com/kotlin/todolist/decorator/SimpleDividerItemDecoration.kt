package com.kotlin.todolist.decorator

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.support.v7.widget.RecyclerView.LayoutParams
import android.support.v7.widget.RecyclerView.State
import android.view.View

import com.kotlin.todolist.R

/**
 * Created by JGabrielFreitas on 04/10/16.
 */
class SimpleDividerItemDecoration(context: Context) : ItemDecoration() {

    val divider = ContextCompat.getDrawable(context, R.drawable.line_divider)!!

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: State?) {

        val left  = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount

        for (i in 0..childCount - 1) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as LayoutParams
            val top    = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }
}
