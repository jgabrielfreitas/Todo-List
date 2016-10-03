package com.jgabrielfreitas.core.database

import com.activeandroid.query.Select
import com.jgabrielfreitas.core.Task

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
class TaskDao : Database<Task> {

    override fun save(t: Task) {
        t.save()
    }

    override fun selectAll(): List<Task> {
        return Select().all().from(Task::class.java).execute()
    }

    override fun delete(id: Int) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(id: Int) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}