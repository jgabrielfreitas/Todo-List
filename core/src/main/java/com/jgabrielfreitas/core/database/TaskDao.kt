package com.jgabrielfreitas.core.database

import com.activeandroid.query.Select
import com.jgabrielfreitas.core.Task

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
class TaskDao : Database<Task> {

    val ON_TRASH  = 1
    val NON_TRASH = 2

    override fun delete(any: Task) {
        any.delete()
    }

    override fun update(any: Task) {
        any.save()
    }

    override fun save(t: Task) {
        t.save()
    }

    override fun selectAll(): List<Task> {
        return Select().all().from(Task::class.java).execute()
    }

    fun findTask(id:Long) : Task {
        return Select().all().from(Task::class.java).where("Id = ?", id).executeSingle()
    }

    fun selectAllNonTrash() : List<Task> {
        return Select().all().from(Task::class.java).where("TRASH = ?", NON_TRASH).execute()
    }

    fun selectAllOnTrash() : List<Task> {
        return Select().all().from(Task::class.java).where("TRASH = ?", ON_TRASH).execute()
    }
}