package com.example.shop.data

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import java.util.prefs.Preferences

class MyApplication : Application() {

}

val Context.dataStore by preferencesDataStore(name = "settings")