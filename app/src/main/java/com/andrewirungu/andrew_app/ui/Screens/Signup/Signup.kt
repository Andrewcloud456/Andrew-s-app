package com.andrewirungu.andrew_app.ui.Screens.Signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.andrewirungu.andrew_app.R
import com.andrewirungu.andrew_app.ui.Components.LottieAnimationWidget
import com.andrewirungu.andrew_app.ui.Navigation.Routes
import com.andrewirungu.andrew_app.ui.theme.PurpleGrey80
import com.andrewirungu.andrew_app.ui.theme.primaryColor
import com.andrewirungu.andrew_app.ui.theme.secondaryColor

@Composable
fun SignupScreens(navController: NavHostController, modifier: Modifier,){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
        LottieAnimationWidget(R.raw.phone, 300.dp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Please Sign in", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("Full Name")},
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = PurpleGrey80,
                unfocusedTextColor = secondaryColor,
                focusedBorderColor = primaryColor
            )

        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Enter Email")},
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = PurpleGrey80,
                unfocusedTextColor = secondaryColor,
                focusedBorderColor = primaryColor,
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Enter Password")},
            shape = RoundedCornerShape(24.dp),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_password_24),
                    contentDescription = "Password"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = PurpleGrey80,
                unfocusedTextColor = secondaryColor,
                focusedBorderColor = primaryColor,
            ),
            visualTransformation = PasswordVisualTransformation()



            )
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedButton(
            onClick = {navController.navigate(Routes.Home.name)},
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = primaryColor
            )
        ) { Text(text = "Sign Up")}



    }

}
