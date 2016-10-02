package com.jgabrielfreitas.core.database

import android.content.Context
import com.jgabrielfreitas.core.Task
import io.realm.RealmQuery

/**
 * Created by JGabrielFreitas on 02/10/16.
 */
class TaskDao(context: Context) : AbstractDao<Task>(context) {

    override fun realmObjectClass(): Class<Task> {
        return Task::class.java
    }
}