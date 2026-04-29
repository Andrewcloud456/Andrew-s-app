package com.andrewirungu.andrew_app.ui.Onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.andrewirungu.andrew_app.ui.Navigation.Routes

@Composable
fun OnboardingScreen(navController: NavHostController,modifier: Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedButton(onClick = { navController.navigate(Routes.Login.name)}) {
            Text(text ="Proceed")
        }
    }
}