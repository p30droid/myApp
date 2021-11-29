package com.androidlearn.digiandroid.models

interface ILoginView<T> {

    fun showProgressBar();
    fun hideProgressBar();
    fun onUsernameError();
    fun onPasswordError();
    fun onFailure(error: String);
    fun onError(error: String)
    fun onSuccess(data: T);


}