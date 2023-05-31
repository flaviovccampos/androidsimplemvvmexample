package com.example.simplemvvmexample

import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private val loginRepository = LoginRepository()

    init {
        textWelcome.value = "Hello MVVM Example"
    }

    fun welcome(): LiveData<String>{
        return textWelcome
    }

    fun login(): LiveData<Boolean>{
        return login
    }

    fun doLogin(email: String, password: String){
        login.value = loginRepository.doLogin(email = email, password = password)
    }

}