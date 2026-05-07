package com.andrewirungu.andrew_app.Mainscreen


import android.R.attr.padding
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.ActionBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andrewirungu.andrew_app.ui.Navigation.Routes
import com.andrewirungu.andrew_app.ui.theme.secondaryColor


data class Transaction(
    val title: String,
    val amount: String,
    val date: String,
    val isIncome: Boolean
)
@Composable
fun AccountScreens(navController: NavHostController,modifier: Modifier) {

    val transactions = listOf(
        Transaction("Salary", "+ KES 85,000", "07 May 2026", true),
        Transaction("Supermarket", "- KES 2,300", "06 May 2026", false),
        Transaction("Netflix", "- KES 1,200", "05 May 2026", false),
        Transaction("Mpesa Deposit", "+ KES 15,000", "04 May 2026", true),
        Transaction("Electricity Bill", "- KES 3,500", "03 May 2026", false)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Routes.Home.name) },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Home") }
                )

                NavigationBarItem(
                    selected = true,
                    onClick = { navController.navigate(Routes.Account.name) },
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
                    text = "My Account",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = secondaryColor
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1565C0)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.AccountBalance,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Column {

                                Text(
                                    text = "Equity Bank",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "**** 1234",
                                    color = Color.White.copy(alpha = 0.8f)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = "Available Balance",
                            color = Color.White.copy(alpha = 0.8f)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "KES 152,340.50",
                            color = Color.White,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Recent Transactions",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = secondaryColor
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            items(transactions) { transaction ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        if (transaction.isIncome)
                                            Color(0xFFE8F5E9)
                                        else
                                            Color(0xFFFFEBEE),
                                        shape = RoundedCornerShape(12.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector =
                                        if (transaction.isIncome)
                                            Icons.Default.ArrowDownward
                                        else
                                            Icons.Default.ArrowUpward,
                                    contentDescription = null,
                                    tint =
                                        if (transaction.isIncome)
                                            Color(0xFF2E7D32)
                                        else
                                            Color(0xFFC62828)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {

                                Text(
                                    text = transaction.title,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = transaction.date,
                                    color = Color.Gray,
                                    fontSize = 13.sp
                                )
                            }
                        }

                        Text(
                            text = transaction.amount,
                            color =
                                if (transaction.isIncome)
                                    Color(0xFF2E7D32)
                                else
                                    Color(0xFFC62828),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}




