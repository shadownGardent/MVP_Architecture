package com.example.mvp_architecture.presenter

class LoginSuccessPresenter(
    private val successView: Contract.LoginSuccessActivityContract
) : Contract.LoginSuccesPresenterContract {
    override fun onReady(msg: String) {
        successView.showWelcomeMessage(msg)
    }

}