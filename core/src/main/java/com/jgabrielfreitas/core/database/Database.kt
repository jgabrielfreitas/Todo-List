package com.jgabrielfreitas.core.database

import com.jgabrielfreitas.core.Task

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
interface Database<T> {

    fun selectAll() : List<Task>

    fun save(any: T)

    fun delete(any: T)

    fun update(any: T)

}