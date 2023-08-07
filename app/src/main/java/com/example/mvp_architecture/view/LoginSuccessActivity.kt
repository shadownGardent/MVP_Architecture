package com.example.mvp_architecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_architecture.R
import com.example.mvp_architecture.databinding.ActivityLoginSuccessBinding
import com.example.mvp_architecture.presenter.Contract
import com.example.mvp_architecture.presenter.LoginSuccessPresenter

class LoginSuccessActivity : AppCompatActivity(), Contract.LoginSuccessActivityContract {
    private lateinit var binding: ActivityLoginSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val msg = getString(R.string.text_welcome) + " "
                        intent?.getStringExtra(EXTRA_MESSAGE)
        LoginSuccessPresenter(this).onReady(msg)
    }


    override fun showWelcomeMessage(message: String) {
        binding.textWelcome.text = message
    }

    companion object {
        const val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    }

}