package com.andrewirungu.andrew_app.ui.Screens.Login

import android.R.attr.label
import android.R.attr.text
import android.R.attr.visibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.andrewirungu.andrew_app.R
import com.andrewirungu.andrew_app.ui.Components.LottieAnimationWidget
import com.andrewirungu.andrew_app.ui.Navigation.Routes
import com.andrewirungu.andrew_app.ui.theme.primaryColor
import com.andrewirungu.andrew_app.ui.theme.secondaryColor

@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier) {
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }
    var visibility by remember {mutableStateOf(false)}


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {

        LottieAnimationWidget(R.raw.phone, 300.dp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Please Login to Start",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,

                )
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            label = {
                Text(text = "Enter Email")
            },
            shape = RoundedCornerShape(24.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email",
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text(text = "Enter Password") },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_password_24),
                    contentDescription = "Password"
                )
            },

        visualTransformation = if (visibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },

                shape = RoundedCornerShape(24.dp),
        trailingIcon = {
            IconButton(
                onClick = { visibility = !visibility }
            ) {
                if (visibility) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.baseline_visibility_off_24),
                        contentDescription = "Password"
                    )
                } else {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.outline_visibility_24),
                        contentDescription = "Password"
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.outline_password_24),
                        contentDescription = "Password",
                    )
                }
            }

    }
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = primaryColor
            ),
            shape = RoundedCornerShape(24.dp)
        ) {Text(text = "Login")}

        Spacer(modifier = Modifier.height(20.dp))

        Row{
            TextButton(
                onClick = { navController.navigate(Routes.ForgotPassword.name) },
            ){Text(text = "Forgot Password",
                color = secondaryColor,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            }


            TextButton(
                onClick = { navController.navigate(Routes.Signup.name) },
            ){Text(text = "Sign Up",
                color = secondaryColor,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                )}


        }
    }
}
