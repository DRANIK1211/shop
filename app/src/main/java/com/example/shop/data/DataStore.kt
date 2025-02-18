package com.example.shop.data

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.core.DataStore
import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "setting")

class SettingsDataStoreService(val context: Context) {

    private val ONBOARD = "ONBOARD"
//    suspend fun save(data: String, key: String) {
//        context.dataStore.edit {
//            it[stringPreferencesKey(key)] = data
//        }
//    }
//
//    fun getByKey(key: String): Flow<String> =
//        context.dataStore.data.map {
//            return@map it[stringPreferencesKey(key)] ?: 1
//        }

    suspend fun saveOnboard(num: Int) {
        context.dataStore.edit {
            it[intPreferencesKey(ONBOARD)]= num
        }
    }

    suspend fun setOne(){
        context.dataStore.edit {
            it[intPreferencesKey(ONBOARD)]= 1
        }
    }
    fun getOnboard() = context.dataStore.data.map {
        return@map it[intPreferencesKey(ONBOARD)]?:1
    }

}