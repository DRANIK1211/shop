package com.example.shop.presentation.onboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.shop.domain.OnboardingViewModel
import com.example.shop.presentation.home.HomeSc
import com.example.shop.presentation.onboard.components.Onboard1
import com.example.shop.presentation.onboard.components.Onboard2
import com.example.shop.presentation.onboard.components.Onboard3
import kotlinx.serialization.Serializable


@Serializable
object Onboard

@Composable
fun OnboardScreen(navController: NavController){



    var flag by remember { mutableIntStateOf(1) }
    Column(
        modifier = Modifier.fillMaxSize().background(
            brush = Brush.verticalGradient(
                listOf(
                    Color(72, 178, 231),
                    Color(68, 169, 220),
                    Color(43, 107, 139)
                )
            )
        ).padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        when(flag){
            1 -> {
                Onboard1()
            }
            2 -> {
                Onboard2()
            }
            3 -> {
                Onboard3()
            }
            else -> {

            }
        }
        //Onboard1()

        Button(
            onClick = {
                when(flag){
                    1 -> {
                        flag = 2
                    }
                    2 -> {
                        flag = 3
                    }
                    3 -> {
                        navController.navigate(HomeSc)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                .padding(bottom = 36.dp, start = 20.dp, end = 20.dp)
                .height(50.dp),
            shape = RoundedCornerShape(corner = CornerSize(13.dp)),
            colors = ButtonColors(
                contentColor = Color(43, 43, 43),
                containerColor = Color.White,
                disabledContentColor = Color(43, 43, 43),
                disabledContainerColor = Color.White
            )

        ) {
            Text(
                text = if(flag == 1)"Начать" else "Далее",
                color = Color(43, 43, 43),
                fontSize = 14.sp,
                fontWeight = FontWeight(400)
            )
        }

    }

}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun OnboardPreview(){

}