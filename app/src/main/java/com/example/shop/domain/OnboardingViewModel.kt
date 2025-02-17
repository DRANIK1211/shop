package com.example.shop.domain

import android.app.Application
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.data.PreferencesManager
import kotlinx.coroutines.launch


class OnboardingViewModel(private val preferencesManager: PreferencesManager) : ViewModel() {


}