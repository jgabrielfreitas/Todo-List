package com.jgabrielfreitas.core.database

import com.jgabrielfreitas.core.Task

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
interface Database<T> {

    fun selectAll() : List<Task>

    fun save(t: T)

    fun delete(id : Int)

    fun update(id : Int)

}