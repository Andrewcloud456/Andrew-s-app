package com.andrewirungu.andrew_app.Data.Repository

import com.andrewirungu.andrew_app.Data.Models.models

interface AuthService {
    suspend fun registerUser(user: models)
    suspend fun loginUser(user: models)
    suspend fun resetPassword(email: String)
    suspend fun getUserProfile(user: models)
    suspend fun logoutUser()
}