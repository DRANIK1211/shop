package com.example.shop.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shop.R
import com.example.shop.ui.theme.ShopTheme

@Composable
fun Menu(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(106.dp)
            .padding(bottom = 0.dp)

            //.background(Color.Gray),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.menu1),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth().shadow(
                    elevation = 106.dp
                )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.incart2),
                contentDescription = null,
                modifier = Modifier.height(88.dp).width(88.dp).clickable {

                }

            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().height(106.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row (
                modifier = Modifier.width(120.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.home_active),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {

                    }
                )
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.favorites_disactive),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {

                    }
                )
            }
            Row (
                modifier = Modifier.width(120.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.notification_disactive),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {

                    }
                )
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.profile_disactive),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp).height(24.dp).clickable {

                    }
                )
            }
        }

    }
}

@Preview
@Composable
fun MenuPreview() {
    ShopTheme {
        Menu(modifier = Modifier)
    }

}