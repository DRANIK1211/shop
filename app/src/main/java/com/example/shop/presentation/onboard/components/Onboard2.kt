package com.example.shop.presentation.onboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shop.R

@Composable
fun Onboard2() {

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Image(
                painter = painterResource(R.drawable.onboard2),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Начнем\nпутешествие",
                fontSize = 34.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(top = 60.dp, start = 30.dp, end = 30.dp)
            )
            Text(
                text = "Умная, великолепная и модная коллекция Изучите сейчас",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(top = 12.dp, start = 30.dp, end = 30.dp)
            )
            Row(
                modifier = Modifier.padding(top = 40.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier.width(23.dp)
                        .clip(CircleShape),
                    color = Color(43, 107, 139),
                    thickness = 10.dp
                )
                HorizontalDivider(
                    modifier = Modifier.width(55.dp).padding(start = 12.dp)
                        .clip(CircleShape),
                    color = Color.White,
                    thickness = 10.dp
                )

                HorizontalDivider(
                    modifier = Modifier.width(35.dp).padding(start = 12.dp)
                        .clip(CircleShape),
                    color = Color(43, 107, 139),
                    thickness = 10.dp
                )
            }
        }

    }

}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun Onboard2Preview() {
    Onboard2()
}