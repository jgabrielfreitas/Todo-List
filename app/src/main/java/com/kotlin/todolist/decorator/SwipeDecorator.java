package com.kotlin.todolist.decorator;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback;

import static android.support.v7.widget.helper.ItemTouchHelper.LEFT;
import static android.support.v7.widget.helper.ItemTouchHelper.RIGHT;

/**
 * Created by JGabrielFreitas on 04/10/16.
 */
public class SwipeDecorator extends SimpleCallback {

    public SwipeDecorator() {
        super(0, LEFT | RIGHT);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(ViewHolder viewHolder, int direction) {

    }

}
