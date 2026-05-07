package com.andrewirungu.andrew_app.ui.Screens.Signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrewirungu.andrew_app.Data.Models.models
import com.andrewirungu.andrew_app.Data.Models.signupmodels
import com.andrewirungu.andrew_app.Data.Repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignupViewModel: ViewModel() {
    private val repository = Repository()
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message
    fun registerUser(user: models) {
        if (user.Email.isBlank() || user.Password.isBlank()) {
            _message.value = "Email and Password cannot be empty"
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(user.Email).matches()) {
            _message.value = "Invalid email format"
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            _message.value = "Welcome"

            try {
                repository.registerUser(user)


                _message.value = "Account created successfully"

            } catch (e: Exception) {
                _message.value = e.message ?: "Registration Failed"
            }
        }
    }

}