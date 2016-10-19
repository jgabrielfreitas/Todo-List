package com.jgabrielfreitas.core.application

import android.app.Application
import com.activeandroid.ActiveAndroid
import com.facebook.stetho.Stetho

/**
 * Created by JGabrielFreitas on 03/10/16.
 */
class CoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
        ActiveAndroid.initialize(this)
    }
}