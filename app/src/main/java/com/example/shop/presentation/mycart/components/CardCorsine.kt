package com.example.shop.presentation.mycart.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shop.R
import com.example.shop.data.Boot
import com.kevinnzou.compose.swipebox.SwipeBox
import com.kevinnzou.compose.swipebox.SwipeDirection
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardCorsineComponent(card: Boot, navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val statesKol = remember { mutableStateOf(1) }
    SwipeBox(
        modifier = Modifier.fillMaxWidth(),
        swipeDirection = SwipeDirection.Both,
        startContentWidth = 58.dp,
        startContent = { swipeableState, endSwipeProgress ->
            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .height(104.dp)
                    .width(58.dp)
                    .background(
                        color = Color(72, 171, 231),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = null,
                        modifier = Modifier
                            .width(14.dp)
                            .height(14.dp)
                            .clickable {
                                if (statesKol.value < 10) {
                                    statesKol.value += 1
                                }
                            }
                    )


                    Text(
                        text = statesKol.value.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                    Image(
                        painter = painterResource(R.drawable.minus),
                        contentDescription = null,
                        modifier = Modifier
                            .width(14.dp)
                            .height(14.dp)
                            .clickable {
                                if (statesKol.value > 1) {
                                    statesKol.value -= 1
                                }
                            }
                    )
                }

                coroutineScope.launch {
                    swipeableState.animateTo(0)
                }
            }
        },
        endContentWidth = 58.dp,
        endContent = { swipeableState, endSwipeProgress ->
            Box(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(104.dp)
                    .width(58.dp)
                    .background(
                        color = Color(248, 114, 101),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                coroutineScope.launch {
                    swipeableState.animateTo(0)
                }
            }
        }
    ) { state, _, _ ->

        var start = 0.dp
        var end = 0.dp

        if (state.currentValue == 0) {
            start = 0.dp
            end = 0.dp
        } else if (state.currentValue == 2) {
            start = 60.dp
            end = 0.dp
        } else if (state.currentValue == 1) {
            start = 0.dp
            end = 60.dp
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = start, end = end)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .height(104.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .width(87.dp)
                    .height(85.dp)
                    .padding(start = 10.dp)
                    .background(color = Color(247, 247, 249), shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.botinok),
                    contentDescription = null,
                    modifier = Modifier
                        .width(86.dp)
                        .height(55.dp)
                )
            }

            Column(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = card.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "₽" + card.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(top = 9.dp)
                )
            }
        }
    }


}


@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun CardPreview() {

}
