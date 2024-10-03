package com.example.medicinepro.ui.screen.authentication.login

import androidx.lifecycle.ViewModel
import com.example.medicinepro.domain.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthenticationRepository
) : ViewModel() {

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()


    fun onEmailChange(text: String) {
        _email.value = text
    }

    fun onPasswordChange(text: String) {
        _password.value = text
    }

    fun requestSignIn() {
        TODO("viewmodel request sign in")
    }
}