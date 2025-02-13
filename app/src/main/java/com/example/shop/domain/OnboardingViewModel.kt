package com.example.shop.domain

import android.app.Application
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shop.data.dataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class OnboardingViewModel(application: Application) : AndroidViewModel(application) {

    private val dataStore = application.dataStore

//    fun saveName(name: String) {
//        viewModelScope.launch {
//            saveName(name)
//        }
//    }

    fun getName(): MutableStateFlow<Int> {
        val liveData = MutableStateFlow<Int>(1)
        viewModelScope.launch {
            liveData.postValue(getName())

        }
        return liveData
    }

    suspend fun saveName(name: String) {
        val nameKey = stringPreferencesKey("name")
        dataStore.edit { preferences ->
            preferences[nameKey] = name
        }
    }

    suspend fun getName(): String? {
        val nameKey = stringPreferencesKey("name")
        return dataStore.data
            .map { preferences ->
                preferences[nameKey] ?: "Default Name"
            }
            .first() // Получаем первое значение из потока
    }
}