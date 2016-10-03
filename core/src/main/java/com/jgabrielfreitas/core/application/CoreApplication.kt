package com.jgabrielfreitas.core.application

import android.app.Application
import com.activeandroid.ActiveAndroid

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
class CoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ActiveAndroid.initialize(this)
    }
}