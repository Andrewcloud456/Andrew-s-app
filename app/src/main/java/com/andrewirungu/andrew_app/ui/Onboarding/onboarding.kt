package com.andrewirungu.andrew_app.ui.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.NavHostController
import com.andrewirungu.andrew_app.ui.Navigation.Routes
import com.andrewirungu.andrew_app.ui.theme.PurpleGrey80

import com.andrewirungu.andrew_app.ui.theme.primaryColor


@Composable
fun OnboardingScreen(navController: NavHostController,modifier: Modifier){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFC8A2C8))
            .padding(16.dp)


    ) {

        Text(
            text = "Welcome to Finance Management",
            style = TextStyle(
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
        )

        Spacer(modifier = Modifier.height(20.dp))



        OutlinedButton(onClick = { navController.navigate(Routes.Login.name)},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = PurpleGrey80
            )) {

            Text(text ="Continue")
        }
    }
}