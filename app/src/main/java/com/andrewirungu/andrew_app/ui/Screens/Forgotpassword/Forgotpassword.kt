package com.andrewirungu.andrew_app.ui.Screens.Forgotpassword

import android.R.attr.typeface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andrewirungu.andrew_app.R
import com.andrewirungu.andrew_app.ui.Components.LottieAnimationWidget
import com.andrewirungu.andrew_app.ui.theme.PurpleGrey40
import com.andrewirungu.andrew_app.ui.theme.PurpleGrey80
import com.andrewirungu.andrew_app.ui.theme.primaryColor
import com.andrewirungu.andrew_app.ui.theme.secondaryColor


@Composable
fun ForgotPasswordScreens(modifier: Modifier) {
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp).fillMaxSize()
    ) {
        LottieAnimationWidget(R.raw.phone, 300.dp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Forgot Password ?",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = secondaryColor

            ))
        Spacer(modifier= Modifier.height(24.dp))

        OutlinedTextField(
            value = emailInput,
            onValueChange = {emailInput = it },
            label = {Text(text = "Enter Email")},
            shape = RoundedCornerShape(24.dp),
            placeholder = {
                Text(text = "Enter Email")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = PurpleGrey80,
                unfocusedTextColor = secondaryColor,
                focusedBorderColor = primaryColor
                )


)
        OutlinedButton(
            onClick = {},
            border = ButtonDefaults.outlinedButtonBorder( enabled = false),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = primaryColor
            ),
        ) {
            Text("Reset Password")
        }

    }
}




