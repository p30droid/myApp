package com.androidlearn.digiandroid.config

import android.app.Application
import android.content.Context
import com.androidlearn.digiandroid.di.DaggerUserComponent
import com.androidlearn.digiandroid.di.UserComponent
import com.androidlearn.digiandroid.di.UserModule
import com.google.android.gms.ads.MobileAds

class ConfigApp : Application() {


    var instance: ConfigApp? = null

    @JvmName("getInstance1")
    fun getInstance(): ConfigApp? {
        return instance
    }

    fun getContext(): Context? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this)
        instance = this
    }

    fun getComponent(): UserComponent? {
        return DaggerUserComponent.builder()
            .userModule(UserModule()).build()
    }


}