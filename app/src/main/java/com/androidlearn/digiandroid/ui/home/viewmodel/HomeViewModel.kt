package com.androidlearn.digiandroid.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.androidlearn.digiandroid.api.IService
import com.androidlearn.digiandroid.api.RetrofitClient.retrofit
import com.androidlearn.digiandroid.models.BaseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application) {


//    lateinit var mutableLiveData: MutableLiveData<BaseModel>
        lateinit var mutableLiveData: MutableLiveData<BaseModel>


    fun getHomeData(): MutableLiveData<BaseModel> {
      //  if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData<BaseModel>()
        //}
        loadData()
        return mutableLiveData
    }

    fun loadData() {

        val iService = retrofit.create(IService::class.java)
        iService.home().enqueue(object : Callback<BaseModel> {
            override fun onResponse(call: Call<BaseModel>, response: Response<BaseModel>) {
               mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<BaseModel>, t: Throwable) {
                TODO("Not yet implemented")
                //mutableLiveData.value =
            }

        })


    }



}