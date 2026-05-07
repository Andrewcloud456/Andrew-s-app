package com.andrewirungu.andrew_app.Mainscreen
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//import androidx.compose.runtime.mutableStateOf
//import com.andrewirungu.andrew_app.Client.RetrofitClient
//import com.andrewirungu.andrew_app.Data.Repository.BankAccountRepo
//
//
//class AccountViewModel {
//
//    class AccountViewModel : ViewModel() {
//
//        val accountState = mutableStateOf<BankAccountRepo?>(null)
//
//        fun loadAccount() {
//
//            viewModelScope.launch {
//
//                try {
//
//                    val response =
//                        RetrofitClient.api.getAccountDetails()
//
//                    accountState.value = response
//
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            }
//        }
//    }
//}