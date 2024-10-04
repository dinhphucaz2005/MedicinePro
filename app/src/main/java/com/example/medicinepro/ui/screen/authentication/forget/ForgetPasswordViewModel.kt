package com.example.medicinepro.ui.screen.authentication.forget

import androidx.lifecycle.ViewModel
import com.example.medicinepro.domain.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val repository: AuthenticationRepository
) : ViewModel() {

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _code = MutableStateFlow("")
    val code = _code.asStateFlow()

    private val _newPassword = MutableStateFlow("")
    val newPassword = _newPassword.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()

    fun onEmailChange(text: String) {
        _email.value = text
    }

    fun sendCode() {
        TODO("Not yet implemented")
    }

    fun resetPassword() {
        TODO("Not yet implemented")
    }

    fun verifyCode() {
        TODO("Not yet implemented")
    }

    fun onPasswordChange(text: String) {
        _newPassword.value = text
    }

    fun onConfirmPasswordChange(text: String) {
        _confirmPassword.value = text
    }
}
