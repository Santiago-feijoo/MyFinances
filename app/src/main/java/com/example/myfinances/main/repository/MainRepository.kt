package com.example.myfinances.main.repository

import android.content.Context
import com.example.myfinances.main.response.MainResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(private val response: MainResponse) {
    /** METODOS **/
    suspend fun validateLogin(username: String, password: String) {
        withContext(Dispatchers.IO) {
            when {
                username.isEmpty() -> {
                    response.incorrectUsername(true)

                }
                password.isEmpty() -> {
                    response.incorrectPassword(true)

                }
                else -> {
                    response.responseLogin(true)

                }

            }

        }

    }

}