package com.andrewirungu.andrew_app.Data.Repository

import retrofit2.http.GET

interface BankAccountService {
    @GET("accounts")
    suspend fun getAccountDetails(): BankAccountRepo
}