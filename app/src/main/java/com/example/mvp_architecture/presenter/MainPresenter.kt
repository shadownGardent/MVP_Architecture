package com.example.mvp_architecture.presenter

import android.view.View
import com.example.mvp_architecture.model.User

class MainPresenter(
    private val mainview: Contract.MainActivityContract,
    private val model: Contract.ModelContract
) : Contract.MainPresenterContract, Contract.ModelContract.OnLoginResponseListener{
    override fun onResponse(user: User?) {
        mainview.showProgressbar(View.GONE)
        if(user != null) {
            mainview.startLoginSuccessActivity(user)
        }else{
            mainview.showLoginFailed()
        }
    }

    override fun onLoginButtonClick(username: String, password: String) {
        mainview.showProgressbar(View.VISIBLE)
        if(username.isEmpty() || password.isEmpty()) {
            mainview.showInputError()
            mainview.showProgressbar(View.INVISIBLE)
        }else {
            model.login(username, password, this)
        }
    }
}
