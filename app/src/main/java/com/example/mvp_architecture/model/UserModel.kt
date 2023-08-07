package com.example.mvp_architecture.model

import com.example.mvp_architecture.presenter.Contract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserModel : Contract.ModelContract {
    override fun login(
        username: String,
        password: String,
        listener: Contract.ModelContract.OnLoginResponseListener
    ) {
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        scope.launch {
            delay(2000L)
            val users = Utils.fakeData()
            var loginUser: User? = null
            for (user in users) {
                if (user.username.compareTo(username) == 0 &&
                    user.password.compareTo(password) == 0
                ) {
                    loginUser = user
                    break
                }
            }
            listener.onResponse(loginUser)
        }
    }
}