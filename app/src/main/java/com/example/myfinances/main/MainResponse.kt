package com.example.myfinances.main

interface MainResponse {
    /** FIRMAS **/
    fun incorrectUsername(response: Boolean)
    fun incorrectPassword(response: Boolean)
    fun responseLogin(response: Boolean)

}