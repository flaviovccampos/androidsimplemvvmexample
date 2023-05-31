package com.example.simplemvvmexample

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplemvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setObserver()

    }

    private fun setObserver() {
        viewModel.welcome().observe(this) {
            binding.textWelcome.text = it
        }

        viewModel.login().observe(this) {
            if(it){
                Toast.makeText(applicationContext, "Login SUCCESS", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "Login ERROR", Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_login){
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email= email, password= password)
        }
    }

}
