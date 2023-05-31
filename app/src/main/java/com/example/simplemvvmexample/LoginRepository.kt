package com.example.simplemvvmexample

class LoginRepository {

    fun doLogin(email: String, password: String): Boolean{
        return email != "" && password != ""
    }

}