package com.androidlearn.digiandroid.models

interface IResponseView<T> {

    fun onUsernameError();
    fun onPasswordError();
    fun onFailure(error: String);
    fun onError(error: String)
    fun onSuccess(data: T);

}