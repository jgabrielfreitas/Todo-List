package com.kotlin.todolist.activities

import android.os.Bundle
import com.jgabrielfreitas.core.activity.BaseActivity
import com.jgabrielfreitas.datacontroller.DataController
import com.kotlin.todolist.BuildConfig
import com.kotlin.todolist.BuildConfig.KEY_INTRO_DONE

/**
 * Created by JGabrielFreitas on 17/11/16.
 */
class ValidatorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // check if the user has already passed the welcome screen
        if (DataController(this).readStringData(KEY_INTRO_DONE) != null)
            doIntent(MainActivity::class.java)
        else
            doIntent(WelcomeActivity::class.java)

        finish()
    }

}