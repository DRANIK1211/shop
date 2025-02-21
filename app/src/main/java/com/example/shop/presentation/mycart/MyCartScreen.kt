package com.example.shop.presentation.mycart

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.shop.R
import com.example.shop.data.Boot
import com.example.shop.domain.BaseViewModel
import com.example.shop.presentation.home.HomeSc
import com.example.shop.presentation.mycart.components.CardCorsineComponent
import kotlinx.coroutines.flow.filter
import kotlinx.serialization.Serializable

@Serializable
data object MyCartSc


@Composable
fun MyCartScreen(navController: NavController){

    val viewModel:BaseViewModel = viewModel<BaseViewModel>()
    val boots = viewModel.boots.collectAsState()
    val cartList = boots.value.filter { it.count > 0 }

    Column {
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth(),

            ) {

            Text(
                text = "Корзина",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,

                )

            Image(
                imageVector = ImageVector.vectorResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .height(44.dp)
                    .width(44.dp)
                    .clickable {
                        navController.navigate(HomeSc)
                    }
            )

        }




        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(cartList){ it ->

                CardCorsineComponent(it, navController)

            }
        }
    }


}
