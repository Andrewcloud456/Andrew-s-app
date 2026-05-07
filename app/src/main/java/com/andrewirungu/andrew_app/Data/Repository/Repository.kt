package com.andrewirungu.andrew_app.Data.Repository

import com.andrewirungu.andrew_app.Data.Models.models
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest


class Repository: AuthService {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://jxzqxankesyisepyzlfd.supabase.co",
        supabaseKey = "sb_publishable_YIxsLXjkG0hWFfslyl2JCg_I_PsPxbu"
    )  {
        install(Postgrest)
        install(Auth)
    }


    override suspend fun registerUser(userDetails: models)  {
        supabase.auth.signUpWith(Email) {
            email = userDetails.Email
            password = userDetails.Password
        }
    }

    override suspend fun loginUser(userDetails: models)  {
        val user = supabase.auth.signInWith(Email) {
            email = userDetails.Email
            password = userDetails.Password
        }
    }

    override suspend fun resetPassword(email: String) {
        supabase.auth.resetPasswordForEmail(email = email)
    }

    override suspend fun getUserProfile(user: models) {
//        TODO("Not yet implemented")
    }

    override suspend fun logoutUser() {
        supabase.auth.signOut()
    }

}