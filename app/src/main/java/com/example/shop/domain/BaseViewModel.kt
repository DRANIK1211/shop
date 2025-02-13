package com.example.shop.domain

import android.app.Application
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.data.SupabaseClient
import com.example.shop.data.dataStore
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class BaseViewModel(application: Application) : AndroidViewModel(application) {





    private val _user = MutableStateFlow<UserInfo?>(value = null)
    val user = _user.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun login(){
        // проверка на пустое
        viewModelScope.launch {
            val u =SupabaseClient.signUpNewUser(email.value,password.value)
        }
    }

}