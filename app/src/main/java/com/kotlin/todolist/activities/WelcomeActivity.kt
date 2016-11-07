package com.kotlin.todolist.activities

import android.R.color.white
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment
import com.kotlin.todolist.R

class WelcomeActivity : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(AppIntroFragment.newInstance("Sincronismo", "Agora você pode sincronizar as suas tarefas com a nuvem!", R.drawable.cloud, android.R.color.background_light))
        addSlide(AppIntroFragment.newInstance("Sincronismo", "Agora você pode sincronizar as suas tarefas com a nuvem!", R.drawable.cloud, R.color.cloud_background))
        addSlide(AppIntroFragment.newInstance("Sincronismo", "Agora você pode sincronizar as suas tarefas com a nuvem!", R.drawable.cloud, R.color.cloud_background))

        setSeparatorColor(white)

    }

    override fun onDonePressed(currentFragment: Fragment?) = startApplication()

    override fun onSkipPressed(currentFragment: Fragment?) = startApplication()

    private fun startApplication() {
        val startAppIntent = Intent(this, MainActivity::class.java)
        startActivity(startAppIntent)
    }
}
