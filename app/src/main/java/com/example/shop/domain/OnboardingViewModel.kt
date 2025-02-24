package com.example.shop.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.data.SettingsDataStoreService
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class OnboardingViewModel(application: Application) : AndroidViewModel(application) {


    private val dataStore = SettingsDataStoreService(application)

    val onboardStat = dataStore.getOnboard()
    fun clear() {
        viewModelScope.launch {
            dataStore.setOne()
        }
    }

    fun incOnboard() {
        viewModelScope.launch {
            var num = onboardStat.firstOrNull()
            if (num == null) num = 1
            dataStore.saveOnboard(num + 1)
        }

    }


}