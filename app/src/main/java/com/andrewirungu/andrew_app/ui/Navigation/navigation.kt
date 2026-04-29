package com.andrewirungu.andrew_app.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.andrewirungu.andrew_app.ui.Onboarding.OnboardingScreen
import com.andrewirungu.andrew_app.ui.Screens.Forgotpassword.ForgotPasswordScreens
import com.andrewirungu.andrew_app.ui.Screens.Login.LoginScreen
import com.andrewirungu.andrew_app.ui.Screens.Signup.SignupScreens


@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier){
    NavHost(
        navController = navController,
        startDestination = Routes.Onboarding.name
    ) {
        composable (Routes.Onboarding.name){ OnboardingScreen(navController, modifier) }
        composable (Routes.Login.name){ LoginScreen(navController, modifier) }
        composable (Routes.Signup.name){ SignupScreens(navController, modifier) }
        composable (Routes.ForgotPassword.name){ ForgotPasswordScreens(navController, modifier) }
    }
}