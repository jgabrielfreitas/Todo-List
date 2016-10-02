package com.jgabrielfreitas.core.database

import android.content.Context
import com.jgabrielfreitas.core.Task
import io.realm.*
import io.realm.RealmConfiguration.Builder

/**
 * Created by JGabrielFreitas on 02/10/16.
 */
abstract class AbstractDao<T : RealmObject>(context: Context) {

    open var realm   : Realm?  = null
    val context : Context = context

    fun init() {

        Realm.init(context)
        val realmConfiguration = Builder().name("Tasks.realm").schemaVersion(1).build()
        realm = Realm.getInstance(realmConfiguration)
    }

    fun save() {
        realm?.beginTransaction()
        realm?.commitTransaction()
    }

    abstract fun realmObjectClass() : Class<T>

    private fun where() : RealmQuery<T> {
        return realm!!.where(realmObjectClass())
    }

    fun selectAll() : RealmResults<T>? {
        return where().findAll()
    }
}