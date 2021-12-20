package com.androidlearn.digiandroid.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.androidlearn.digiandroid.R
import com.androidlearn.digiandroid.databinding.ActivityLoginBinding
import com.androidlearn.digiandroid.models.BaseModel
import com.androidlearn.digiandroid.models.ILoginView

class LoginActivity : AppCompatActivity(), ILoginView<String> {

    lateinit var binding: ActivityLoginBinding


    lateinit var presneter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presneter = LoginPresenter(this)

        binding.btnLogin.setOnClickListener {
            var user: String = binding.edtUsername.text.toString()
            var password: String = binding.edtPassword.text.toString()
            presneter.login(user, password)
        }


    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onUsernameError() {
        binding.edtUsername.error = getString(R.string.username_req)
    }

    override fun onPasswordError() {
        binding.edtPassword.error = getString(R.string.password_req)
    }

    override fun onFailure(error: String) {
        Toast.makeText(applicationContext, getString(R.string.fail_request), Toast.LENGTH_LONG)
            .show()
    }

    override fun onError(error: String) {
        Toast.makeText(applicationContext, getString(R.string.data_req), Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(data: String) {
        Toast.makeText(applicationContext, getString(R.string.success), Toast.LENGTH_LONG).show()
    }
}