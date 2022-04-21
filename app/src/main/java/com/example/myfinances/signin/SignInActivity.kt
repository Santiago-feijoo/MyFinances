package com.example.myfinances.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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

        initComponents()

    }

    private fun initComponents() {
        addListOfDocumentTypes(resources.getStringArray(R.array.listOfDocumentTypes))
        initListener()

    }

    private fun initListener() {
        binding.toolbarSignIn.setNavigationOnClickListener {
            it.isEnabled = false
            this.finish()

        }

    }

    private fun addListOfDocumentTypes(listOfDocumentTypes: Array<String>) {
        val documentTypeAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listOfDocumentTypes)
        binding.listTypesOfDocument.setAdapter(documentTypeAdapter)

    }

}