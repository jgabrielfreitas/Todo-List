package com.jgabrielfreitas.core

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by JGabrielFreitas on 02/10/16.
 */
class Task: RealmObject() {

    @PrimaryKey
    var id          : Int?   = null
    var title       : String = ""
    var taskContent : String = ""

}