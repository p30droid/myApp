package com.androidlearn.digiandroid.ui.categoryProducts

import android.app.Application
import android.util.Log
import com.androidlearn.digiandroid.api.RetrofitClient.retrofit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.androidlearn.digiandroid.api.IService
import com.androidlearn.digiandroid.api.RetrofitClient
import com.androidlearn.digiandroid.models.BaseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryProductsViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var mutableLiveData : MutableLiveData<BaseModel>

    fun getCategoryProducts(catid: Int): MutableLiveData<BaseModel> {
        if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
        }
        loadCategory(catid)
        return mutableLiveData
    }

    private fun loadCategory(catid: Int) {
        val iService = retrofit.create(IService::class.java)
        iService.getProductCategory(catid).enqueue(object : Callback<BaseModel?> {
            override fun onResponse(call: Call<BaseModel?>, response: Response<BaseModel?>) {
                mutableLiveData!!.value = response.body()
            }

            override fun onFailure(call: Call<BaseModel?>, t: Throwable) {
                //mutableLiveData.setValue();
                Log.e("", "")
            }
        })
    }
}