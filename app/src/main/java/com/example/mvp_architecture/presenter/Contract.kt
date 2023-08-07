package com.example.mvp_architecture.presenter

import com.example.mvp_architecture.model.User

interface Contract {
    // interface được implement bởi MainActivity
    interface MainActivityContract {
        fun startLoginSuccessActivity(user: User)
        fun showProgressbar(visibility: Int)
        fun showLoginFailed()
        fun showInputError()
    }

    // interface được implement bởi LoginSuccessActivity
    interface LoginSuccessActivityContract {
        fun showWelcomeMessage(message: String)
    }
//-------------------------------------------------------------------------------------->

    // interface để presenter giao tiếp với UserModel
    interface ModelContract {
        interface OnLoginResponseListener {
            fun onResponse(user: User?)
        }

        fun login(username: String, password: String, listener: OnLoginResponseListener)
    }

    // interface để presenter giao tiếp với MainActivity
    interface MainPresenterContract {
        fun onLoginButtonClick(username: String, password: String)
    }

    // interface để presenter giao tiếp vs LoginSuccessActivity
    interface LoginSuccesPresenterContract {
        fun onReady(msg: String)
    }
}