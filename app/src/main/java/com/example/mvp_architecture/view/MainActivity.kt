package com.example.mvp_architecture.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_architecture.R
import com.example.mvp_architecture.databinding.ActivityMainBinding
import com.example.mvp_architecture.model.User
import com.example.mvp_architecture.model.UserModel
import com.example.mvp_architecture.presenter.Contract
import com.example.mvp_architecture.presenter.MainPresenter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), Contract.MainActivityContract {
    private lateinit var binding: ActivityMainBinding
    private var presenter: Contract.MainPresenterContract? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showProgressbar(View.INVISIBLE)
        binding.btnLogin.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            presenter?.onLoginButtonClick(username, password)
        }
        presenter = MainPresenter(this, UserModel())
    }

    override fun startLoginSuccessActivity(user: User) {
        val intent = Intent(this, LoginSuccessActivity::class.java)
        intent.putExtra(LoginSuccessActivity.EXTRA_MESSAGE, user.displayName)
        startActivity(intent)
    }

    override fun showProgressbar(visibility: Int) {
        binding.progressBar.visibility = visibility
    }

    override fun showLoginFailed() {
        Snackbar.make(
            binding.root,
            getString(R.string.text_login_failed),
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun showInputError() {
        Snackbar.make(
            binding.root,
            getString(R.string.text_input_invalid),
            Snackbar.LENGTH_LONG
        ).show()
    }
}