package com.example.myfinances.main.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfinances.menu.view.MenuActivity
import com.example.myfinances.R
import com.example.myfinances.Tools
import com.example.myfinances.databinding.ActivityMainBinding
import com.example.myfinances.main.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /** ATRIBUTOS **/
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(parent, name, context, attrs)

        initListener()

    }

    private fun initListener() {
        binding.buttonLogin.setOnClickListener {
            binding.buttonLogin.isEnabled = false
            viewModel.validateLogin(binding.editTextUsername.text.toString().trim(), binding.editTextPassword.text.toString().trim())

        }

    }

    private fun observer() {
        viewModel.incorrectUsername.observe(this) { response ->
            if(!response) {
                binding.buttonLogin.isEnabled = true
                binding.editTextUsername.error = getString(R.string.alerta_username_login)

            }

        }

        viewModel.incorrectPassword.observe(this) { response ->
            if(!response) {
                binding.buttonLogin.isEnabled = true
                binding.editTextPassword.error = getString(R.string.alerta_clave)

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

        Tools().alert("success", "¡${getString(R.string.bienvenido)}!", Toast.LENGTH_SHORT, this.applicationContext)

    }

}