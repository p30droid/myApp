package com.androidlearn.digiandroid.config

import android.app.Application
import com.google.android.gms.ads.MobileAds

class ConfigApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this)

    }

}