package com.example.myfinances.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfinances.R
import com.example.myfinances.databinding.ActivitySignInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity: AppCompatActivity() {
    /** ATRIBUTOS **/
    private lateinit var binding: ActivitySignInBinding

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}