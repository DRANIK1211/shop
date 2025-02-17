package com.example.shop.presentation.details

import android.telecom.Call.Details
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
data object DetailsSc

@Composable
fun DetailsScreen(navController: NavController, id: String){
    Text(id)
}
