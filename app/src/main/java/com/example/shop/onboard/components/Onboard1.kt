package com.example.shop.onboard.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shop.R
import com.example.shop.onboard.Onboard


@Composable
fun Onboard1() {

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Добро пожаловать",
                fontSize = 30.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(bottom = 130.dp, start = 50.dp, end = 58.dp)
            )
            Image(
                painter = painterResource(R.drawable.onboard1),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Row(
                modifier = Modifier.padding(top = 26.dp)
            ) {

                HorizontalDivider(
                    modifier = Modifier.width(43.dp)
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
fun Onboard1Preview() {
    Onboard1()
}