package com.example.myfinances.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfinances.menu.MenuActivity
import com.example.myfinances.R
import com.example.myfinances.utils.Tools
import com.example.myfinances.databinding.ActivityMainBinding
import com.example.myfinances.signin.SignInActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /** ATRIBUTOS **/
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
        observer()

    }

    private fun initListener() {
        binding.buttonLogin.setOnClickListener {
            it.isEnabled = false
            viewModel.validateLogin(binding.editTextUsername.text.toString().trim(), binding.editTextPassword.text.toString().trim())

        }

        binding.textViewCreateAccount.setOnClickListener {
            openSignIn()

        }

    }

    private fun observer() {
        viewModel.incorrectUsername.observe(this) { response ->
            if(response) {
                binding.buttonLogin.isEnabled = true
                binding.layoutUsername.error = getString(R.string.alerta_username_login)
                binding.layoutPassword.error = ""

            }

        }

        viewModel.incorrectPassword.observe(this) { response ->
            if(response) {
                binding.buttonLogin.isEnabled = true
                binding.layoutUsername.error = ""
                binding.layoutPassword.error = getString(R.string.alerta_clave)

            }

        }

        viewModel.responseLogin.observe(this) { response ->
            if(response) {
                openMenu()

            }

        }

    }

    private fun openMenu() {
        intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)

        Toast.makeText(this, "¡${getString(R.string.bienvenido)}!", Toast.LENGTH_SHORT).show()

    }

    private fun openSignIn() {
        intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)

    }

}