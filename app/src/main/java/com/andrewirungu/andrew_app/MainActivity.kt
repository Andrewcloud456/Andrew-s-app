package com.andrewirungu.andrew_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andrewirungu.andrew_app.ui.Screens.Forgotpassword.ForgotPasswordScreens
import com.andrewirungu.andrew_app.ui.Screens.Login.LoginScreen
import com.andrewirungu.andrew_app.ui.theme.Andrew_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Andrew_AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ForgotPasswordScreens(modifier = Modifier.padding(innerPadding
                    ))

                }
            }
        }
    }
}

//@Composable

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Andrew_AppTheme {

    }
}