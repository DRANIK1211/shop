package com.example.shop.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shop.data.dataStore

class OnboardingViewModel(application: Application) :AndroidViewModel(application) {

    private val dataStore = application.dataStore


    fun saveStep(){

    }
}