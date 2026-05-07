package com.andrewirungu.andrew_app.Mainscreen

import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings

import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andrewirungu.andrew_app.ui.Navigation.Routes
import com.andrewirungu.andrew_app.ui.theme.primaryColor
import com.andrewirungu.andrew_app.ui.theme.secondaryColor

//class MainScreen : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FinanceHomePage()
//        }
//    }
//}

//data class Transaction(
//    val title: String,
//    val amount: String
//)

@Composable
fun FinanceHomePage(navController: NavHostController,modifier: Modifier) {

//    val transactions = listOf(
//        Transaction("Netflix", "- $15"),
//        Transaction("Salary", "+ $2500"),
//        Transaction("Groceries", "- $120"),
//        Transaction("Transport", "- $30")
//    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {navController.navigate(Routes.Home.name)},
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Home") }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {navController.navigate(Routes.Account.name)},
                    icon = { Icon(Icons.Default.AccountBox, null) },
                    label = { Text("Account") }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("Profile") }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Settings, null) },
                    label = { Text("Settings") }
                )
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)
        ) {

            item {
                Text(
                    text = "Hello, Andrew ",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = secondaryColor
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF4CAF50)
                    ),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {

                        Text(
                            text = "Total Balance",
                            color = Color.White,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "KES 100,000",
                            color = Color.White,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    SummaryCard(
                        title = "Income",
                        amount = "85,000",
                        color = Color(0xFF2196F3)
                    )

                    SummaryCard(
                        title = "Expenses",
                        amount = "KES 7,000",
                        color = Color(0xFFF44336)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }



//            items(transactions) { transaction ->
//                TransactionItem(transaction),

            }
        }
    }


@Composable
fun SummaryCard(
    title: String,
    amount: String,
    color: Color
) {

    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier.width(160.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = amount,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {

    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = transaction.title,
                fontSize = 18.sp
            )

            Text(
                text = transaction.amount,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (transaction.amount.contains("+"))
                    Color(0xFF4CAF50)
                else
                    Color.Red
            )
        }
    }
}