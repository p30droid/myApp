package com.androidlearn.digiandroid.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://androidsupport.ir/pack/digiAndroid/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}