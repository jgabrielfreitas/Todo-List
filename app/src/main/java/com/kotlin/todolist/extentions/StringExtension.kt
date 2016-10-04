package com.kotlin.todolist.extentions

/**
 * Created by JGabrielFreitas on 04/10/16.
 */

fun String.withEmoji(message: String, emoji: Int) : String = "$message ${emoji.toChar()}"