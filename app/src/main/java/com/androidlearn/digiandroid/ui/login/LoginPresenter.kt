package com.androidlearn.digiandroid.ui.login

import com.androidlearn.digiandroid.models.ILoginView
import com.androidlearn.digiandroid.models.IResponseView
import javax.sql.RowSetListener

class LoginPresenter : IResponseView<String> {
    lateinit var intractor: LoginIntractor
    lateinit var iView: ILoginView<String>

    constructor(iView: ILoginView<String>) {
        intractor = LoginIntractor()
        this.iView = iView

    }

    fun login(username: String, password: String) {

        iView.showProgressBar()
        intractor.login(username, password, this)

    }

    override fun onUsernameError() {

        iView.hideProgressBar()
        iView.onUsernameError()

    }

    override fun onPasswordError() {
        iView.hideProgressBar()
        iView.onPasswordError()
    }

    override fun onFailure(error: String) {
        iView.hideProgressBar()
        iView.onFailure("Error")
    }

    override fun onError(error: String) {
        iView.hideProgressBar()
        iView.onError("")
    }

    override fun onSuccess(data: String) {
        iView.hideProgressBar()
        iView.onSuccess(data)
    }


}