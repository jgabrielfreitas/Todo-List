package com.jgabrielfreitas.core

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table


/**
 * Created by JGabrielFreitas on 02/10/16.
 */

@Table(name = "Task")
class Task : Model() {

    val ON_TRASH  = 1
    val NON_TRASH = 2

    @Column(name = "TITLE")   var title        : String? = null
    @Column(name = "CONTENT") var content      : String? = null
    @Column(name = "TRASH")   var movedToTrash : Int     = NON_TRASH

}