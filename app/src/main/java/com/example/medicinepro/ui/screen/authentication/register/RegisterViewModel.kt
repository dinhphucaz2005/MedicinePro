package com.example.medicinepro.ui.screen.authentication.register

import androidx.lifecycle.ViewModel
import com.example.medicinepro.domain.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthenticationRepository
) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _nickname = MutableStateFlow("")
    val nickname = _nickname.asStateFlow()

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber = _phoneNumber.asStateFlow()

    private val _dateOfBirth = MutableStateFlow("")
    val dateOfBirth = _dateOfBirth.asStateFlow()

    private val _gender = MutableStateFlow("")
    val gender = _gender.asStateFlow()

    fun onRegisterClick() {
        TODO("Not yet implemented")
    }

    fun onEmailChange(text: String) {
        _email.value = text
    }

    fun onNameChange(text: String) {
        _name.value = text
    }

    fun onPasswordChange(text: String) {
        _password.value = text
    }

    fun saveUser() {
        TODO("Not yet implemented")
    }
}