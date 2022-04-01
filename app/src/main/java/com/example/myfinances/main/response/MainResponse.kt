package com.example.myfinances.main.response

interface MainResponse {
    /** FIRMAS **/
    fun incorrectUsername(response: Boolean)
    fun incorrectPassword(response: Boolean)
    fun responseLogin(response: Boolean)

}