package com.example.myfinances.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfinances.databinding.ActivityMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity: AppCompatActivity() {
    /** ATRIBUTOS **/
    private lateinit var binding: ActivityMenuBinding

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}