package com.androidlearn.digiandroid.api

import com.androidlearn.digiandroid.models.BaseModel
import com.androidlearn.digiandroid.models.Category
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {


    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<ResponseBody>

    @GET("home.php")
    fun home(): Call<BaseModel>


    @GET("getCategories.php")
    fun category(): Call<Category>

    @POST("getProductCategory.php")
    fun getProductCategory(@Field("id") id : Int): Call<BaseModel>


    @GET("getCategories.php")
    fun getCategory() : Observable<Category>

}