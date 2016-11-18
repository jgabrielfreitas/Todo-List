package com.kotlin.todolist.activities

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import com.jgabrielfreitas.datacontroller.DataController
import com.kotlin.todolist.BuildConfig
import com.kotlin.todolist.BuildConfig.INTRO_DONE
import com.kotlin.todolist.BuildConfig.KEY_INTRO_DONE
import com.kotlin.todolist.R
import com.kotlin.todolist.R.color.*
import com.kotlin.todolist.R.drawable.*
import com.kotlin.todolist.R.string.*
import com.kotlin.todolist.fragments.SlideFragment

class WelcomeActivity : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create fragments to show
        addSlide(SlideFragment(getString(title_sync),  getString(msg_now_you_can_sync_tasks), cloud, cloud_background))
        addSlide(SlideFragment(getString(title_check), getString(msg_easy_tasks),             check, check_background))
        addSlide(SlideFragment(getString(title_focus), getString(msg_keep_in_focus),          man,   person_background))

        // show skip and done bottom
        setSkipText(getString(R.string.skip))
        setDoneText(getString(R.string.done))
    }

    override fun onDonePressed(currentFragment: Fragment?) = startApplication()

    override fun onSkipPressed(currentFragment: Fragment?) = startApplication()

    private fun startApplication() {

        // will never display the intro screen again.
        DataController(this).writeData(KEY_INTRO_DONE, INTRO_DONE)

        // initialize application and kill activity
        val startAppIntent = Intent(this, MainActivity::class.java)
        startActivity(startAppIntent)
        finish()
    }
}
