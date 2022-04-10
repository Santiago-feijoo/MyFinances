package com.example.myfinances.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor() {
    /** ATRIBUTOS **/
    private lateinit var response: MainResponse

    /** METODOS **/
    fun setInterface(response: MainResponse) {
        this.response = response

    }

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