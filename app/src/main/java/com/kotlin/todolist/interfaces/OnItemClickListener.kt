package com.kotlin.todolist.interfaces

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
interface OnItemClickListener<T> {

    public fun onItemClick(item: T) : Unit

}