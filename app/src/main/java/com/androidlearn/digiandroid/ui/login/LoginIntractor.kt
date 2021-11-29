package com.androidlearn.digiandroid.ui.login

import com.androidlearn.digiandroid.api.IService
import com.androidlearn.digiandroid.api.RetrofitClient
import com.androidlearn.digiandroid.models.BaseModel
import com.androidlearn.digiandroid.models.IResponseView
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginIntractor {


    fun login(username : String , password  : String , listener : IResponseView<String>) {
      //  var retrofit = RetrofitClient.retrofit
        var service : IService = RetrofitClient.retrofit.create(IService::class.java)

       var call = service.login(username , password)

        if(username.isEmpty()) {
            listener.onUsernameError()
            return
        }
        if(password.isEmpty()) {
            listener.onPasswordError()
            return
        }

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                listener.onSuccess(response.body()!!.string());
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        } );


    }


}