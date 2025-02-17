package com.example.shop.data

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.core.DataStore
import android.app.Application
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class PreferencesManager(private val dataStore: DataStore<Preferences>) {


}