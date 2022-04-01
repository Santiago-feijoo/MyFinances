package com.example.myfinances.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfinances.main.repository.MainRepository
import com.example.myfinances.main.response.MainResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel(), MainResponse {
    /** ATRIBUTOS **/
    val incorrectUsername: LiveData<Boolean> get() = _incorrectUsername
    private val _incorrectUsername = MutableLiveData<Boolean>()

    val incorrectPassword: LiveData<Boolean> get() = _incorrectPassword
    private val _incorrectPassword = MutableLiveData<Boolean>()

    val responseLogin: LiveData<Boolean> get() = _responseLogin
    private val _responseLogin = MutableLiveData<Boolean>()

    /** METODOS **/
    fun validateLogin(username: String, password: String) {
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO) {
            repository.validateLogin(username, password)

        }

    }

    override fun incorrectUsername(response: Boolean) {
        _incorrectUsername.postValue(response)

    }

    override fun incorrectPassword(response: Boolean) {
        _incorrectPassword.postValue(response)

    }

    override fun responseLogin(response: Boolean) {
        _responseLogin.postValue(response)

    }

}